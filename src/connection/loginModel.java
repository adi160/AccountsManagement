package connection;

import java.sql.*;
public class loginModel {
  Connection conection;
  public loginModel () {
   conection = sqlConnection.Connector();
   if (conection == null) {

   System.out.println("connection not successful");
    System.exit(1);}
  }
  
  public boolean isDbConnected() {
   try {
  return !conection.isClosed();
 } catch (SQLException e) {
  // TODO Auto-generated catch block
  e.printStackTrace();
  return false;
 }
}
public boolean isLogin(String email,String password) throws SQLException{
    PreparedStatement pt=null;
    ResultSet rs=null;
    String query="select * from admin where email=? and password=?";
    try{
       pt=conection.prepareStatement(query);
       pt.setString(1, email);
       pt.setString(2, password);
       rs=pt.executeQuery();
       if(rs.next()){
           return true;
       }else{
           return false;
       }
    }catch(Exception e){
        return false;
    }finally{
        rs.close();
        pt.close();
    }
    
}  
}
