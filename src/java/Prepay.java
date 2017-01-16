import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
public class Prepay extends HttpServlet {
    int cred_bank;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    Connection con;
 @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String button = request.getParameter("button");
         if ("button1".equals(button)) {
            // first pay to buy credits and after returing to site below code will work
            HttpSession htsess=request.getSession(false);
            String emailid=(String)htsess.getAttribute("current_emailid");
            String password=(String)htsess.getAttribute("current_pass");
            System.out.println(emailid+"    "+password);
            try
            {
             Class.forName("org.apache.derby.jdbc.ClientDriver");
              con=DriverManager.getConnection("jdbc:derby://localhost:1527/Login_Database","himanshu","himanshu");
             PreparedStatement ps =con.prepareStatement
                             ("select CREDITCOUNT from HIMANSHU.HIMANSHU where emailidid=? and password=?");
            ps.setString(1, emailid);
            ps.setString(2, password);
            ResultSet rs =ps.executeQuery();
            while(rs.next()){
            cred_bank=rs.getInt("creditcount");
            increase_the_credits(cred_bank,emailid,password);
            }
            }catch(Exception ex)
            {
                System.out.println("cannot fetch required value from database due to some error");
                ex.printStackTrace();
            }
            RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
            rd.forward(request, response);
        }
    }
    public void increase_the_credits(int cred_,String emailid,String password)
{
    cred_bank=cred_+10;
    try{
    Statement statement=con.createStatement();
    String query="UPDATE HIMANSHU.HIMANSHU SET creditcount=? where emailid=? and password=?";
    pstmt=con.prepareStatement(query);
    pstmt.setInt(1,cred_bank);
    pstmt.setString(2, emailid);
    pstmt.setString(3, password);
    pstmt.executeUpdate();
    }catch(Exception ex)
    {
        System.out.println("cannot update database due to some error");
        ex.printStackTrace();
    }
}
}