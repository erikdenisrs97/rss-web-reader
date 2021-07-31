package models;

public class FeedMessage {
  
  private String link;
  private String title;
  private String description;

  public String getLink() {
    return this.link;
  }

  public String getTitle() {
    return this.title;
  }

  public String getDescription() {
    return this.description;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setDescription(String description) {
    this.description = description;
  }
  
}
