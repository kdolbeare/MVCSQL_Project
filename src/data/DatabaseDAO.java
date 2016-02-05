package data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseDAO
{
	private static String url = "jdbc:mysql://localhost:3306/companydb";
	private static String username = "queryapp";
	private static String password = "queryapp";
	private static Connection conn;

	public void getDatabaseConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e)
		{
			System.out.println("the exception is: " + e);
		}
	}

	public List<ArrayList<Object>> doQuery(String s)
	{
		List<ArrayList<Object>> results = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;

		try
		{
			getDatabaseConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(s);

			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();

			ArrayList<Object> columns = new ArrayList<>();
			for (int i = 1; i <= columnCount; i++)
			{
				String columnName = rsmd.getColumnName(i);
				columns.add(columnName);
			}
			results.add(columns);

			while (rs.next())
			{
				ArrayList<Object> values = new ArrayList<>();
				for (int i = 1; i <= columnCount; i++)
				{
					String value = rs.getString(i);
					values.add(value);
				}
				results.add(values);
			}

		} catch (Exception e)
		{
			System.out.println("the exception is: " + e);
			ArrayList<Object> error = new ArrayList<>();
			String errorMessage = "An error has occurred ... please try again.";
			error.add(errorMessage);
			results.add(error);
			return results;

		} finally
		{
			try
			{
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e)
			{
				System.out.println("in doQuery finally");
			}
		}
		return results;
	}

	public Object doUpdate(String s)
	{
		Statement stmt = null;
		int count = 0;

		try
		{
			getDatabaseConnection();
			stmt = conn.createStatement();
			count = stmt.executeUpdate(s);

		} catch (Exception e)
		{
			System.out.println("the exception is: " + e);
			String errorMessage = "An error has occurred ... please try again. 0 ";
			return errorMessage;

		} finally
		{
			try
			{
				stmt.close();
				conn.close();
			} catch (Exception e)
			{
				System.out.println("in doUpdate finally");
			}

		}
		return count;
	}

}
