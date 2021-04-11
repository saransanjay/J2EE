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
public class ProductRemover extends HttpServlet {
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		
		ServletContext context = getServletContext();
		ServletConfig config = getServletConfig();
		PrintWriter out = response.getWriter();
		
		String proID = request.getParameter("removeproid");
		String dbDriver = context.getInitParameter("DataBaseDriver");
		String dbUrl = context.getInitParameter("DataBaseUrl");
		String dbUser = config.getInitParameter("DBUserName");
		String dbPswd =config.getInitParameter("DBPassWord");
		String query ="delete from PRODUCT_DATA_TB where PRODUCT_ID ="+proID;
		
		DB dataBaseObj = new DB();
		dataBaseObj.getConnection(dbDriver, dbUrl, dbUser, dbPswd);
		dataBaseObj.updateTable(query);
		if(proID.equals(""))
		{
			RequestDispatcher rd =request.getRequestDispatcher("/product.html");
			response.setContentType("text/html");
			out.print("<h3>Enter the ProductID then Click the Delete Button</h3>");
			rd.include(request, response);	
		}
		else 
		{
			RequestDispatcher rd =request.getRequestDispatcher("/product.html");
			response.setContentType("text/html");
			out.print("<h3>Product has Successfully Removed</h3>");
			rd.include(request, response);
		}
		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		doGet(request,response);
	}

	
	

}
