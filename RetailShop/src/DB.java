import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

import java.sql.ResultSet;
import java.sql.SQLException;
@SuppressWarnings("serial")
public class DB extends HttpServlet{
	ServletConfig config = getServletConfig();
	ServletContext context = getServletContext();
private Connection connection = null;
private Statement smt = null;
private ResultSet resultSet= null;
private int resultCode = 0;
String conUserName = config.getInitParameter("UserName");
String conPassWord = config.getInitParameter("PassWord");
String conUrl = context.getInitParameter("DataBaseUrl");
String conDriver = context.getInitParameter("DataBaseDriver");
public void getConnection() {
try{
	Class.forName(conDriver);
	connection = DriverManager.getConnection(conUrl, conUserName, conPassWord);
	System.out.println("DB Connected");
	smt = connection.createStatement();
	System.out.println("Statement Created");
	}
	catch(SQLException e) 
	{
		System.out.println("problem in connection");
	} 
	catch (ClassNotFoundException e) 
	{
		System.out.println("ClassNotFoundException");
	}
}
public ResultSet selectTable(String query)  {
	try {
		resultSet = smt.executeQuery(query);
	} catch (SQLException e) {
		System.out.println("problem in resultSet");
	}
	return resultSet;
}
public int updateTable(String query) {
	try {
		resultCode = smt.executeUpdate(query);
	} catch (SQLException e) {
		System.out.println("problem in updateTable");	
	}
	return resultCode;	
}
public void close() {
	
	try {
		smt.close();
		connection.close();
	} catch (SQLException e) {
		System.out.println("problem in close");	
	}
}

}


