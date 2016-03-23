package machisoccer.google;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GooglePicasaPhotoEntry {

  private String photoUrl;

  private String thumbnailUrl;

  private String picasaPhotoEntryId;

  private String picasaPhotoEntryEditURI;

  private String description;
}