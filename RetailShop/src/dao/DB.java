package dao;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DB{
	
private Connection connection = null;
private Statement smt = null;
private ResultSet resultSet= null;
private int resultCode = 0;



public void getConnection(String dbDriver,String dbUrl,String dbUserName, String dbPswd)
{
try{
	Class.forName(dbDriver);
	connection = DriverManager.getConnection(dbUrl, dbUserName, dbPswd);
	System.out.println("DB Connected");
	smt = connection.createStatement();
	System.out.println("Statement Created");
	}
	catch(SQLException e) 
	{
		System.out.println("problem in connection" + e);
	} 
	catch (ClassNotFoundException e) 
	{
		System.out.println("ClassNotFoundException" );
		 e.printStackTrace();
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
		System.out.println("resultCode");
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


