package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

  public static final String URL = "jdbc:postgresql://postgres-container:5432/mydb";
  public static final String USER = "postgres";
  public static final String PASSWD = "passwd";

  public Connection getConnection() {
    
    try {
      Class.forName("org.postgresql.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    try {
      return DriverManager.getConnection(
        URL, USER, PASSWD);
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
  }
}
