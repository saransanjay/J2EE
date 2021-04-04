import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
public class MainFile extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException ,IOException
{
	String n = request.getParameter("NAME");
	PrintWriter out = response.getWriter();
	response.setContentType("text/html");
	out.print("Hi "+n);
	out.print("<h2>SendRedirect is Working</h2>");
}
public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException ,IOException
{
	doPost(request,response);
	}
}
