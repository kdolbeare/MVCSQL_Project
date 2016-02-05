package data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseDAO
{
	private static String url = "jdbc:mysql://localhost:3306/companydb";
	private static String username = "queryapp";
	private static String password = "queryapp";

	public List<ArrayList<String>> loadDatabaseInfo(String s) throws ClassNotFoundException, SQLException
	{
		// later on we'll need an array of objects:
		List<ArrayList<String>> results = new ArrayList<>();

		// move these two lines out to a get connection method:
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);

		// these are unique to each method so need in all methods
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(s);

		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();

		ArrayList<String> columns = new ArrayList<>();
		for (int i = 1; i <= columnCount; i++)
		{
			String columnName = rsmd.getColumnName(i);
			columns.add(columnName);
		}
		results.add(columns);

		while (rs.next())
		{
			ArrayList<String> values = new ArrayList<>();
			for (String columnName : columns)
			{
				String value = rs.getString(columnName);
				values.add(value);
			}
			results.add(values);
		}
		rs.close();
		stmt.close();
		conn.close();
		return results;
	}

}
