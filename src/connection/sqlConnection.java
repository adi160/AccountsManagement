package connection;

import java.sql.*;
public class sqlConnection {

   
    public static Connection Connector(){
 try {
  Class.forName("org.sqlite.JDBC");
  Connection conn =DriverManager.getConnection("jdbc:sqlite:admin.sqlite");
  return conn;
 } catch (Exception e) {
  System.out.println(e);
  return null;
  // TODO: handle exception
 }
}
}
