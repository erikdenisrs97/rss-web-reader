package tests;

import java.util.List;

import models.FeedMessage;
import models.RSSReader;

public class RSSReaderTest {
 public static void main(String[] args) {
  RSSReader reader = new RSSReader();

  reader.read("https://rss.tecmundo.com.br/feed");

  List<FeedMessage> messages = reader.getFeedMessages();
  for(FeedMessage message : messages) {
    System.out.println(message.getLink());
  }
 }
 
}
