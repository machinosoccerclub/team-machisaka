package machisoccer.members.models;

public class MemberPhoto {
  private final String rawTitle;

  private final String photoUrl;

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
