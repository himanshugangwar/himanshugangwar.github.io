import java.io.IOException;
import java.io.PrintWriter;
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
public class Signer extends HttpServlet {
    int cred_bank_dec;
    Connection con;
   @Override
   public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter(); 
        String email = request.getParameter("reg_email_one");
        String pass = request.getParameter("reg_pass_one");
        HttpSession htse=request.getSession();
        htse.setAttribute("current_email", email);
        htse.setAttribute("current_pass",pass);
        if(Validate.checkUser(email, pass))
        {
            RequestDispatcher rs = request.getRequestDispatcher("welcome.jsp");
            rs.forward(request, response);
        }
        else
        {
           System.out.println("Username or Password incorrect");
           RequestDispatcher rs = request.getRequestDispatcher("result.jsp");
           rs.forward(request, response);
        }
   }
}