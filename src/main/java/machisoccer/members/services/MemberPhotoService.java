package machisoccer.members.services;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import machisoccer.google.GooglePicasa;
import machisoccer.google.GooglePicasaPhotoEntry;
import machisoccer.members.models.Grade;
import machisoccer.members.models.MemberPhoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberPhotoService {
  private final GooglePicasa googlePicasa;

  private final Comparator<MemberPhoto> byGrade = (m1, m2) -> m1.getGrade().compareTo(m2.getGrade());
  private final Comparator<MemberPhoto> byName = (m1, m2) -> m1.getName().compareTo(m2.getName());

  @Autowired
  public MemberPhotoService(GooglePicasa googlePicasa) {
    this.googlePicasa = googlePicasa;
  }

  public List<MemberPhoto> getMemberPhotos() {
    return googlePicasa.listPhotos().stream()
        .map(this::createMemberPhoto)
        .collect(Collectors.toList());
  }

  public List<MemberPhoto> getMemberPhotos(final List<Grade> grades) {
    List<String> gradeLabels = grades.stream().map(Grade::getLabel).collect(Collectors.toList());

    return googlePicasa.listPhotos().stream()
      .map(this::createMemberPhoto)
      .filter(m -> gradeLabels.contains(m.getGrade()))
      .sorted(byGrade.thenComparing(byName))
      .collect(Collectors.toList());
  }

  private MemberPhoto createMemberPhoto(GooglePicasaPhotoEntry entry) {
    return new MemberPhoto(entry.getDescription(), entry.getPhotoUrl(), entry.getThumbnailUrl());
  }
}
