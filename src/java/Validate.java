import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author sachin vashistha
 */
public class Validate {
    public static boolean checkUser(String email,String pass) 
     {
      boolean st =false;
      try
      {
             Class.forName("org.apache.derby.jdbc.ClientDriver");
             Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/Login_Database","himanshu","himanshu");
             PreparedStatement ps =con.prepareStatement
                             ("select * from HIMANSHU.HIMANSHU where emailid=? and password=?");
         ps.setString(1, email);
         ps.setString(2, pass);
         ResultSet rs =ps.executeQuery();
         st = rs.next();
      }catch(Exception e)
      {
          System.out.println("some error occured while checking");
          e.printStackTrace();
      }
         return st;                 
  }   
}
