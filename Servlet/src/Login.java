import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Login extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException {
		String userName = request.getParameter("user");
		String passWord = request.getParameter("password");
		if((userName == "saran"&&passWord == "sanjay")){
			PrintWriter out = response.getWriter();
			out.print("Welcome Your Login Sucessful");
		}
		
	}
	
}