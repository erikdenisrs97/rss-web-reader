package tests;

import models.RSS;
import models.dao.RSSdao;

public class SaveRSSTest {

  public static void main(String[] args) {
      RSS testRSS = new RSS();
      RSSdao testDAO = new RSSdao();

      testRSS.setLink("https://rss.tecmundo.com.br/feeds");
      testDAO.save(testRSS);
      
  }

}
