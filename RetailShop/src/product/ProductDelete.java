package product;
import javax.servlet.ServletException;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DB;

@SuppressWarnings("serial")
public class ProductDelete extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		
		ServletContext context = getServletContext();
		ServletConfig config = getServletConfig();
		PrintWriter out = response.getWriter();
		
		String dbDriver = context.getInitParameter("DataBaseDriver");
		String dbUrl = context.getInitParameter("DataBaseUrl");
		String dbUser = config.getInitParameter("DBUserName");
		String dbPswd =config.getInitParameter("DBPassWord");
		String query ="DELETE FROM PRODUCT_DATA_TB";
		
		DB dataBaseObj = new DB();
		dataBaseObj.getConnection(dbDriver, dbUrl, dbUser, dbPswd);
		dataBaseObj.selectTable(query);
		
		RequestDispatcher rd =request.getRequestDispatcher("/product.html");
		response.setContentType("text/html");
		out.print("<h3>All the Product are Successfully Cleared  </h3>");
		rd.include(request, response);
		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		doGet(request,response);
	}
	
}
