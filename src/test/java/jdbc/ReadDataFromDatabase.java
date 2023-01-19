package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDatabase {

	public static void main(String[] args) throws SQLException {
		//Step 1 : Create an instance for Driver
		//Driver should be imported from com.mysql.cj.jdbc.Driver
		//new Driver() throws SQLException
		Driver dbDriver = new Driver();
		
		//Step 2 : Register to the dbDriver
		//DRiverManager is in java.sql package
		DriverManager.registerDriver(dbDriver);
		
		//Step 3 : Establish database connection
		//Connection should be imported from java.sql package
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/advsel","root","root");
		
		//Step 4 : Create statement
		// Statement should be imported from java.sql package
		Statement statement = connect.createStatement();
		
		//Step 5 : Execute query to fetch data
		ResultSet result =statement.executeQuery("select * from advsel");
		
		while (result.next()) {
			System.out.println(result.getInt(1)+"\t"+result.getString(3));			
		}
			
		//Modifying DB
		int result2 =statement.executeUpdate("insert into advsel(id,name,address) values (105,'xyz','Hyd');");
		if (result2 ==1) 
			System.out.println("DB updated sucessfully");
		else
			System.out.println("DB not updated");
		
		//Step 6 : Close the database
		connect.close();
		
		}
		
		

	}


