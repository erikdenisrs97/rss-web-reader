package tests;

import model.RSS;
import model.dao.RSSdao;

public class SaveRSSTest {

  public static void main(String[] args) {
      RSS testRSS = new RSS();
      RSSdao testDAO = new RSSdao();

      testRSS.setLink("https://rss.tecmundo.com.br/feed");
      testDAO.save(testRSS);

      System.out.println("SaveRSSTest passed!!");
  }

}
