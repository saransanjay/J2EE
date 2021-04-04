package get;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class GetLogin extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException {
		String userName = request.getParameter("getname");
		String passWord = request.getParameter("getpassword");
		if(userName.equals("get")&&passWord.equals("root"))
				{
				PrintWriter out = response.getWriter();
				out.print("<h1>Welcome Your Login Sucessful</h1>");
				out.print("Get Service is Working");
				}
		
		}
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		doGet(request,response);
	}
	
}
