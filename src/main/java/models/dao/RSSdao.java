package models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.ConnectionFactory;
import models.RSS;

public class RSSdao {
  private Connection conn;

  public RSSdao() {
    this.conn = new ConnectionFactory().getConnection();
  }

  public void save(RSS rss) {
    String query = "INSERT INTO feeds(link) VALUES(?);";

    try {
      PreparedStatement stmt = conn.prepareStatement(query);

      stmt.setString(1, rss.getLink());
      stmt.execute();
      stmt.close();
    } catch(SQLException e) {
        throw new RuntimeException(e);
    }
  }

  public void delete(RSS rss) {
    String query = "DELETE FROM feeds WHERE feed_id = ?;";

    try {
      PreparedStatement stmt = conn.prepareStatement(query);

      stmt.setInt(1, rss.getId());
      stmt.execute();
      stmt.close();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
  }

  public RSS findById(int id) {
    String query = "SELECT * FROM feeds WHERE feed_id = ?;";

    try {
      RSS rss = new RSS();
      PreparedStatement stmt = conn.prepareStatement(query);
      stmt.setInt(1, id);
      ResultSet rs = stmt.executeQuery();
      
      if(rs.next()) {
        rss.setId(rs.getInt("feed_id"));
        rss.setLink(rs.getString("link"));
      }

      stmt.close();
      rs.close();
      return rss;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public List<RSS> getFeeds() {
    String query = "SELECT * FROM feeds;";

    try {
      List<RSS> feeds = new ArrayList<>();
      PreparedStatement stmt = conn.prepareStatement(query);
      ResultSet rs = stmt.executeQuery();

      while(rs.next()) {
        RSS rss = new RSS();
        rss.setId(rs.getInt("feed_id"));
        rss.setLink(rs.getString("link"));
        feeds.add(rss);
      }

      stmt.close();
      rs.close();
      return feeds;
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
  }

}
