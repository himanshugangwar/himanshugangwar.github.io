import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sachin vashistha
 */
public class final_serve extends HttpServlet {
      int cred_bank_dec;
    Connection con;
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession htsess=request.getSession(false);
      String email=(String)htsess.getAttribute("current_email");
      String password=(String)htsess.getAttribute("current_pass");
          boolean checking=check_credits(email,password);
             if(checking==true)
             {
                  request.setAttribute("bool_crediter","true");
                  System.out.println("i am in true section");
             }
             else if(checking==false)
             {
                  request.setAttribute("bool_crediter","false");
                  System.out.println("i am in false section");
             }
             System.out.println("value of checking is "+checking);
                  RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
                  rd.forward(request, response);
}
  public boolean check_credits(String email,String password)
   {
       boolean left_credits=false;
           try
            {
             Class.forName("org.apache.derby.jdbc.ClientDriver");
              con=DriverManager.getConnection("jdbc:derby://localhost:1527/Login_Database","himanshu","himanshu");
             PreparedStatement ps =con.prepareStatement
                             ("select CREDITCOUNT from HIMANSHU.HIMANSHU where emailid=? and password=?");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs =ps.executeQuery();
            while(rs.next()){
            cred_bank_dec=rs.getInt("creditcount");
              }
            if(cred_bank_dec>0)
            {
                left_credits=true;
            }
            }
           catch(Exception ex)
           {
                ex.printStackTrace();
            }
           return left_credits;
}
}