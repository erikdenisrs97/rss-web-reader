package models;

import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RSSReader extends DefaultHandler {

  private static final String ITEM = "item";
  private static final String LINK = "link";
  private static final String TITLE = "title";
  private static final String DESCRIPTION = "description";

  private FeedMessage fm = new FeedMessage();
  private List<FeedMessage> feed = new ArrayList<>();

  private boolean hasLink;
  private boolean hasTitle;
  private boolean hasDescription;

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
    if(ITEM.equalsIgnoreCase(qName)) {
      fm = new FeedMessage();
    }

    switch(qName) {
      case LINK:
        hasLink = true;
        break;
      case TITLE:
        hasTitle = true;
        break;
      case DESCRIPTION:
        hasDescription = true;
        break;
    }
  }

  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
    if(ITEM.equalsIgnoreCase(qName)) {
      feed.add(fm);
    }
  }

  @Override
  public void characters(char[] ch, int start, int lenght) throws SAXException {
    if(hasLink) {
      fm.setLink(new String(ch, start, lenght));
      hasLink = false;
    }
    if(hasTitle) {
      fm.setTitle(new String(ch, start, lenght));
      hasTitle = false;
    }
    if(hasDescription) {
      fm.setDescription(new String(ch, start, lenght));
      hasDescription = false;
    }
  }

  @Override
  public void startDocument() throws SAXException {
  }

  @Override
  public void endDocument() throws SAXException {
  }

  public List<FeedMessage> getFeedMessages() {
    return feed;
  }

}
