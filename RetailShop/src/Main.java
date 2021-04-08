import java.sql.ResultSet;

public class Main {
	public static void main(String args[]) {
		DataBaseConnection dbs = new DataBaseConnection();
		dbs.getConnection();
		String query ="SELECT * FROM BIO_DATA";
		ResultSet resultSet = dbs.SelectTable(query);
		try {
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getDate(3));
				System.out.println(resultSet.getInt(4));
			}
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		try {
		query ="INSERT INTO BIO_DATA VALUES(1112,'Saran','12-Apr-2002',18)";
		System.out.println(dbs.updatetable(query));
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
	}

}
