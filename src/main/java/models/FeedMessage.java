package models;

public class FeedMessage {
  
  private String guid;
  private String title;
  private String description;

  public String getGuid() {
    return this.guid;
  }

  public String getTitle() {
    return this.title;
  }

  public String getDescription() {
    return this.description;
  }

  public void setGuid(String guid) {
    this.guid = guid;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setDescription(String description) {
    this.description = description;
  }
  
}
