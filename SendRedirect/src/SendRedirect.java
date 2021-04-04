import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
public class SendRedirect extends HttpServlet {
 public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException
 {
	 
			 response.sendRedirect("redirect");
		}
		
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		doGet(request,response);
	}
	
}

