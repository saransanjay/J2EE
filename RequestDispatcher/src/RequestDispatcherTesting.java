import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;



@SuppressWarnings("serial")
public class RequestDispatcherTesting extends HttpServlet{
public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
{
	PrintWriter out = response.getWriter();
	String name = request.getParameter("NAME");
	String id =request.getParameter("ID");
	String dob = request.getParameter("DOB");
	if(name.equals("saran")&&id.equals("01")&&dob.equals("12/04/2002")) {
		RequestDispatcher rd = request.getRequestDispatcher("forward");
		rd.forward(request, response);
	}
	else {
		RequestDispatcher rd =request.getRequestDispatcher("/index.html");
		response.setContentType("text/html");
		out.print("<h2>Resquest Dispatcher include is Working</h2>");
		rd.include(request, response);
	}
	
}
public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	doPost(request,response);
}
}
