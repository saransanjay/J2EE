package billing;

import dao.DB;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext; 
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public class ProductBilling extends HttpServlet {
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		ServletContext context = getServletContext();
		ServletConfig config = getServletConfig();
		PrintWriter out = response.getWriter();
		
		int total = 0;
		int count = 0;
		int price = 0;
		int totalBill =0;
		String dbDriver = context.getInitParameter("DataBaseDriver");
		String dbUrl = context.getInitParameter("DataBaseUrl");
		String dbUser = config.getInitParameter("DBUserName");
		String dbPswd = config.getInitParameter("DBPassWord");
		String query = "SELECT * FROM PRODUCT_DATA_TB";
		
		DB dataBaseObj = new DB();
		dataBaseObj.getConnection(dbDriver, dbUrl, dbUser, dbPswd);
		ResultSet rowData = dataBaseObj.selectTable(query);
		try{
			out.print("<head>"
					+ "<title>Billing</title>"
					+ "</head>");
			out.print("<body background='http://silafest.com/wp-content/uploads/2018/01/Gray-plain-website-background.jpg'>");
			out.print("<div align='center'>");
			out.print("<table border ='1'>");
				out.print("<tr>");
					out.print("<th>PRODUCTID</th>"
							+ "<th>PRODUCTNAME</th>"
							+ "<th>PRODUCTPRIC</th>"
							+ "<th>PRODUCTCOUNT</th>"
							+ "<th>TOTAL</th>");
				out.print("</tr>");
			
			while(rowData.next()) {	
				price =rowData.getInt(3);
				count =rowData.getInt(4);
				total=price*count;
				totalBill =totalBill+total;
					out.print("<tr>");
						out.print("<td>"+rowData.getInt(1)+"</td>");
						out.print("<td>"+rowData.getString(2)+"</td>");
						out.print("<td>"+price+"</td>");
						out.print("<td>"+count+"</td>");
						out.print("<td>"+total+"</td>");				
					out.print("</tr>");
			}
					out.print("<tr>");
						out.print("<td>"+""+"</td>");
						out.print("<td>"+""+"</td>");
						out.print("<td>"+""+"</td>");
						out.print("<td>"+""+"</td>");
						out.print("<td>"+"TOTALBILL="+totalBill+"</td>");
					out.print("</tr>");
				out.print("</table>");
			out.print("</div>");
			out.print("<div align='center'>");
				out.print("<br>");
				out.print("<form action='delete'method ='post'>" );					
					out.print("<input style='margin-left:190px;' type ='submit' value ='DELETE'>");
					out.print("<button style='margin-left:190px;' name='button' type='button'>PRINT</button>");
					out.print("</form>");
			out.print("</div>");
			out.print("</body>");
			
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		
		
		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		doGet(request,response);
	}

}
