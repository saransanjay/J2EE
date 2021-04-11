import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SecondServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException
	{

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		Cookie[] ck1 = request.getCookies();
		String n = ck1[0].getValue().toString();
		out.print("Hello " + n);

		out.close();

}
}
