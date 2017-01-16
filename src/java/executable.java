import java.io.*;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sachin vashistha
 */
public class executable extends HttpServlet {
    String line;
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try
    {  
        String command = "C:\\Program Files (x86)\\TamperDetect\\TamperDetect\\TamperDetect_CBSE.exe";
        Process p = Runtime.getRuntime().exec(command,null,new File("C:\\Program Files (x86)\\TamperDetect\\TamperDetect"));
        System.out.println(p.getInputStream());
        
    }  
    catch(Throwable t)
    {
        System.out.println("some error running executable file");
        t.printStackTrace();
    }
 }
}