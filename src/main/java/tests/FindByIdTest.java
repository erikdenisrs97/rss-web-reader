package tests;

import models.RSS;
import models.dao.RSSdao;

public class FindByIdTest {

  public static void main(String[] args) {
    RSSdao dao = new RSSdao();
    RSS rss = dao.findById(1);

    System.out.println(rss.getLink());

  }
  
}
