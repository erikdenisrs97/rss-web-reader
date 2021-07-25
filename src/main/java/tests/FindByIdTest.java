package tests;

import model.RSS;
import model.dao.RSSdao;

public class FindByIdTest {

  public static void main(String[] args) {
    RSSdao dao = new RSSdao();
    RSS rss = dao.findById(1);

    System.out.println(rss.getLink());
    System.out.println("FindByIdTest passed!!");

  }
  
}
