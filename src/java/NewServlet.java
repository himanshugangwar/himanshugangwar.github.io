import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import static java.util.Objects.hash;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.User;

/**
 *
 * @author sachin vashistha
 */
public class NewServlet extends HttpServlet {
    PreparedStatement pstmt=null;
    ResultSet rs=null;
  public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException {
      response.setContentType("text/html");
      PrintWriter pw = response.getWriter();
      try
        {
            String username=request.getParameter("reg_user");
            String password=request.getParameter("reg_pass");
            String emailid=request.getParameter("reg_email");
            boolean remember="true".equals(request.getParameter("checker_signer"));
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/Login_Database","himanshu","himanshu");
            Statement statement=con.createStatement();
            String query="INSERT into HIMANSHU.HIMANSHU(NAME,PASSWORD,EMAILID)VALUES(?,?,?)";
            pstmt=con.prepareStatement(query);
            pstmt.setString(1,username);
            pstmt.setString(2, password);
            pstmt.setString(3, emailid);
            pstmt.executeUpdate();
            request.setAttribute("styles", emailid);
            RequestDispatcher rd=request.getRequestDispatcher("result.jsp");
            rd.forward(request, response);
            System.out.println("gone to jsp");
        }
        catch(Exception ex)
        {
         ex.printStackTrace();
         System.out.println("some error related to database");
        }
}
}