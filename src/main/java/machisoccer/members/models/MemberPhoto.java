package machisoccer.members.models;

import lombok.Getter;

public class MemberPhoto {
  @Getter
  private final String rawTitle;

  @Getter
  private final String photoUrl;

  @Getter
  private final String thumbnailUrl;

  public MemberPhoto(String rawTitle, String photoUrl, String thumbnailUrl) {
    this.rawTitle = rawTitle;
    this.photoUrl = photoUrl;
    this.thumbnailUrl = thumbnailUrl;
  }

  public String getGrade() {
    return rawTitle;
  }

  public String getName() {
    return rawTitle;
  }
}
