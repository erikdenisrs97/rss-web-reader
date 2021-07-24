package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

  public static final String URL = "jdbc:postgresql://localhost/mydb";
  public static final String USER = "postgres";
  public static final String PASSWD = "passwd";

  public Connection getConnection() {
    try {
      return DriverManager.getConnection(
        URL, USER, PASSWD);
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
  }
}
