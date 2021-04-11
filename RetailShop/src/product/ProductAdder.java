package product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.DB;

@SuppressWarnings("serial")
public class ProductAdder extends HttpServlet {
	
	public void doGet(HttpServletRequest request ,HttpServletResponse response)throws IOException,ServletException
	{
			PrintWriter out = response.getWriter();
			ServletConfig config = getServletConfig();
			ServletContext context = getServletContext();
			
		
		
		String proID = request.getParameter("proid");
		String proName = request.getParameter("proname");
		String proPrice =request.getParameter("proprice");
		String proCount = request.getParameter("procount");
		 
		 String dbDriver = context.getInitParameter("DataBaseDriver");
		 String dbUrl = context.getInitParameter("DataBaseUrl");
		 String dbUser = config.getInitParameter("DBUserName");
		 String dbPswd = config.getInitParameter("DBPassWord");
			
		String query ="INSERT INTO PRODUCT_DATA_TB VALUES("+proID+",'"+proName+"',"+proPrice+","+proCount+")";
		
		DB dataBaseObj = new DB();
		dataBaseObj.getConnection(dbDriver, dbUrl, dbUser, dbPswd);
		dataBaseObj.updateTable(query);
		
		
		out.print("<div align ='center'>");
		out.print("<h1>Welcome </h1>");
		out.print("</div>");
		
		if(proID.equals("") && proName.equals("") &&proPrice.equals("")&& proCount.equals(""))
		{
			response.setContentType("text/html");
			out.print("<h3>table inputs are incomplete</h3>");
			RequestDispatcher rd = request.getRequestDispatcher("/product.html");
			rd.include(request, response);
		}
		else
		{
			response.setContentType("text/html");
			out.print("<h3>Product has Successfully Added</h3>");
			RequestDispatcher rd = request.getRequestDispatcher("/product.html");
			rd.include(request, response);
		}
	}
	public void doPost(HttpServletRequest request ,HttpServletResponse response)throws IOException,ServletException
	{
		doGet(request,response);
	}
}
