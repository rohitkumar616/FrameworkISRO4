package genericLibraries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;
/**
 * This class contains reusable methods to perform operations on Database
 * @author SHALINI
 *
 */

public class DatabaseUtility {
	private Connection connection;
	/**
	 * This method is used to initialize and establish database connection
	 * @param url
	 * @param user
	 * @param password
	 */

	public void databaseInitialization(String url, String user, String password) {
		Driver dbDriver = null;
		try {
			dbDriver = new Driver();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			DriverManager.registerDriver(dbDriver);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to fetch data from database
	 * @param querry
	 * @param columnName
	 * @return
	 * @throws SQLException
	 */

	public List<String> readDataFromDatabase(String querry, String columnName) throws SQLException {
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ResultSet result = null;
		try {
			result = statement.executeQuery(querry);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List<String> columnData = new ArrayList<>();
		while (result.next()) {
			columnData.add(result.getString(columnName));
		}
		return columnData;
	}

	public int modifyDatabase(String querry) {
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int result = 0;
		try {
			result = statement.executeUpdate(querry);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * This method closes database
	 */
	public void closeDatabase() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
