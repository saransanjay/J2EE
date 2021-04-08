import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; 

public class DataBaseConnection {
	private Connection connection = null;
	private Statement smt =null;
	private ResultSet resultSet = null;
	private int resultCode = 0;
	private String conUrl ="jdbc:oracle:thin:@localhost:1521:xe";
	private String conUser ="Saran";
	private String conPassword ="root";
	private String conDriver="oracle.jdbc.driver.OracleDriver";
	
	public void getConnection(){
		try {
			Class.forName(conDriver);
			connection=DriverManager.getConnection(conUrl, conUser, conPassword);
			System.out.println("DB Connected");
			smt = connection.createStatement();
			System.out.println("Statement Created");
		}
		catch(Exception ex){
			System.out.println(ex);
		}
	}
	public ResultSet SelectTable(String query) {
		try {
			resultSet=smt.executeQuery(query);
		}
		catch(SQLException ex) {
			System.out.println(ex);
		}
		return resultSet;
	}
	public int updatetable(String query){
		try {
			resultCode = smt.executeUpdate(query); 
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		return resultCode;
	}
	public void close() {
		try {
			smt.close();
			connection.close();
		}
		catch (SQLException ex) {
			System.out.println(ex);		
			}
		
	}

}
