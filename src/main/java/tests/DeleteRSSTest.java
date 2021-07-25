package tests;

import model.RSS;
import model.dao.RSSdao;

public class DeleteRSSTest {
  public static void main(String[] args) {
    RSSdao dao = new RSSdao();
    
    RSS testRSS = dao.findById(1);
    dao.delete(testRSS);

    System.out.println("DeleteRSSTest passed!!!");
  }
}
