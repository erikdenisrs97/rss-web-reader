package models;

public class RSS {

  private int id;
  private String rssLink;

  public int getId() {
    return this.id;
  }

  public String getLink() {
    return this.rssLink;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setLink(String rssLink) {
    this.rssLink = rssLink;
  }
  
}
