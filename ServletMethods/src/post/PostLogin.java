package post;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class PostLogin extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException {
		String userName = request.getParameter("postname");
		String passWord = request.getParameter("postpassword");
		if(userName.equals("post")&&passWord.equals("root"))
			{
				PrintWriter out = response.getWriter();
				out.print("<h1>Welcome Your Login Sucessful</h1>");
				out.print("Post Service is Working");
				}
		
		}
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		doPost(request,response);
	}
	
}
