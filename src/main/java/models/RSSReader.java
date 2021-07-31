package models;

import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

import java.io.*;

public class RSSReader extends DefaultHandler {

  private static final String ITEM = "item";
  private static final String LINK = "link";
  private static final String TITLE = "title";
  private static final String DESCRIPTION = "description";

  private static String currentTag;
  private static boolean hasItem;

  
  public static void main(String[] args) throws Exception {

    RSSReader rr = new RSSReader();
    rr.read("https://rss.tecmundo.com.br/feed");
    
  }

  public void read(String url) {
    SAXParserFactory factory = SAXParserFactory.newInstance();
    SAXParser saxParser;

    try {
      saxParser = factory.newSAXParser();
      saxParser.parse(url, this);
    } catch (ParserConfigurationException | SAXException | IOException e) {
      System.err.println(e);
    }
  }

  @Override
  public void startElement(String uri, String localName, String qName, Attributes atts) {
    currentTag = qName;

    if(currentTag.equalsIgnoreCase(ITEM)) {
      hasItem = true;
    }
  }

  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
    currentTag = "";
  }

  @Override
  public void characters(char[] ch, int start, int lenght) throws SAXException {
    if(hasItem) {
      if(currentTag.equalsIgnoreCase(TITLE)) {
        System.out.println(new String(ch, start, lenght));
      }
      if(currentTag.equalsIgnoreCase(LINK)) {
        System.out.println(new String(ch, start, lenght));
      }
      if(currentTag.equalsIgnoreCase(DESCRIPTION)) {
        System.out.println(new String(ch, start, lenght));
        System.out.println();
      }
    }
  }

  @Override
  public void startDocument() throws SAXException {
    System.out.println("Starting parser...");
  }

  @Override
  public void endDocument() throws SAXException {
    System.out.println("Ending parser....");
  }

}
