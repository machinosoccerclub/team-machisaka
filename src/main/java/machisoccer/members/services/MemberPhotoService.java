package machisoccer.members.services;

import java.util.List;
import java.util.stream.Collectors;

import machisoccer.google.GooglePicasa;
import machisoccer.google.GooglePicasaPhotoEntry;
import machisoccer.members.models.MemberPhoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberPhotoService {
  private final GooglePicasa googlePicasa;

  @Autowired
  public MemberPhotoService(GooglePicasa googlePicasa) {
    this.googlePicasa = googlePicasa;
  }

  public List<MemberPhoto> getMemberPhotos() {
    return googlePicasa.listPhotos().stream()
        .map(this::createMemberPhoto)
        .collect(Collectors.toList());
  }

  private MemberPhoto createMemberPhoto(GooglePicasaPhotoEntry entry) {
    return new MemberPhoto(entry.getDescription(), entry.getPhotoUrl(), entry.getThumbnailUrl());
  }
}
