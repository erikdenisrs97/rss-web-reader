package tests;

import java.util.List;

import model.RSS;
import model.dao.RSSdao;

public class GetFeedsTest {
  public static void main(String[] args) {
    
    RSSdao dao = new RSSdao();

    List<RSS> feeds = dao.getFeeds();
  
    for(RSS rss : feeds) {
      System.out.println("Link: " + rss.getLink());
    }

    System.out.println("GetFeedsTest passed!!");

  }
}
