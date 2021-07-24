package tests;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionFactory;

public class ConnectionTest {
  
  public static void main(String[] args) {
    try {
      Connection conn = new ConnectionFactory().getConnection();
      System.out.println("Connected to PostgreSQL.");
      conn.close();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
  }

}
