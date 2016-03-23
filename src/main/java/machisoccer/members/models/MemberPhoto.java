package machisoccer.members.models;

import lombok.Getter;

public class MemberPhoto {
  @Getter
  private final String rawTitle;

  @Getter
  private final String photoUrl;

  @Getter
  private final String thumbnailUrl;

  private final String grade;

  private final String name;

  public MemberPhoto(String rawTitle, String photoUrl, String thumbnailUrl) {
    this.rawTitle = rawTitle;
    this.photoUrl = photoUrl;
    this.thumbnailUrl = thumbnailUrl;

    String[] splits = rawTitle.split("・", 2);
    if(splits.length>=2) {
      grade = splits[0];
      name = splits[1];
    } else {
      grade = rawTitle;
      name = rawTitle;
    }
  }

  public String getGrade() {
    return grade;
  }

  public String getName() {
    return name;
  }
}
