import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class First extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException
	{
		 

			response.setContentType("text/html"); 
			PrintWriter out = response.getWriter();

			String n = request.getParameter("userName"); 
												
			out.print("Welcome " + n);

			HttpSession session = request.getSession();

			session.setAttribute("name", n);

			out.print("<a href='servlet2'>visit</a>");

			out.close();
		

	}
}
