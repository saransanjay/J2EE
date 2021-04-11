package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DB;



@SuppressWarnings("serial")
public class Login extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	 
		PrintWriter out= response.getWriter();
		ServletConfig config = getServletConfig();
		ServletContext context = getServletContext();
		
		String user = request.getParameter("username");
		String pswd = request.getParameter("password");
		String query = "Select password from retail_login_tb where username = '" + user + "'";
		String actualPswd= null;
		String dbDriver = context.getInitParameter("DataBaseDriver");
		String dbUrl = context.getInitParameter("DataBaseUrl");
		String dbUser = config.getInitParameter("DBUserName");
		String dbPswd = config.getInitParameter("DBPassWord");
		
		
		DB databaseObj = new DB();
		databaseObj.getConnection(dbDriver, dbUrl, dbUser, dbPswd);
		ResultSet result = databaseObj.selectTable(query);
		
		
		try {
				result.next();
				actualPswd = result.getString(1);
			
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		
		if(pswd.equals(actualPswd))
		{
			RequestDispatcher rd = request.getRequestDispatcher("product.html");
			rd.forward(request, response);
			out.print("hi");
		}
		else
		{
			response.setContentType("text/html");
			out.println("Incorrect Username /Password");
			RequestDispatcher rd = request.getRequestDispatcher("/index.html");
			rd.include(request, response);
		}
	
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
