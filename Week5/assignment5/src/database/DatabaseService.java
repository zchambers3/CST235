package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.BeautifulThing;

public class DatabaseService {
	
	public int deleteOne(int id) throws SQLException{
		int numberOfRowsAffected = 0;
		String dbURL = "jdbc:mysql://localhost:3307/beautifulThings";
		String user = "root";
		String password = "root";
		Connection c = null;
		PreparedStatement stmt = null;
		int rowsAffected = 0;
		try {
			c= DriverManager.getConnection(dbURL, user, password);
			System.out.println("Connection is successful " + dbURL 
					+ " User: " +  user 
					+ " Password: " + password);
			stmt = c.prepareStatement("delete from beautifulThings.thingsTable where id = ?");
			stmt.setInt(1, id);
			rowsAffected = stmt.executeUpdate();
			System.out.println("Rows affected " + rowsAffected);
		} catch (SQLException e) {
			System.out.println("Error communicating with the database");
			e.printStackTrace();
		}finally{
			stmt.close();
			c.close();
		}
		return numberOfRowsAffected;
	}
	
	public int insertOne(BeautifulThing b) throws SQLException{
		int numberOfRowsAffected = 0;
		String dbURL = "jdbc:mysql://localhost:3307/beautifulThings";
		String user = "root";
		String password = "root";
		Connection c = null;
		PreparedStatement stmt = null;
		int rowsAffected = 0;
		try {
			c= DriverManager.getConnection(dbURL, user, password);
			System.out.println("Connection is successful " + dbURL 
					+ " User: " +  user 
					+ " Password: " + password);
			stmt = c.prepareStatement("insert into beautifulThings.thingsTable (id, thing_title, thing_description, thing_value) values (null, ?, ?, ?)");
			stmt.setString(1, b.getThingTitle());
			stmt.setString(2, b.getThingDescription());
			stmt.setInt(3, b.getRating());
			rowsAffected = stmt.executeUpdate();
			System.out.println("Rows inserted " + rowsAffected);
		} catch (SQLException e) {
			System.out.println("Error communicating with the database");
			e.printStackTrace();
		}finally{
			stmt.close();
			c.close();
		}
		return numberOfRowsAffected;
	}
	
	public ArrayList<BeautifulThing> readAll() throws SQLException{
		ArrayList<BeautifulThing> everyone = new ArrayList<>();
		BeautifulThing b;
		String dbURL = "jdbc:mysql://localhost:3307/beautifulThings";
		String user = "root";
		String password = "root";
		Connection c = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			c= DriverManager.getConnection(dbURL, user, password);
			System.out.println("Connection is successful " + dbURL 
					+ " User: " +  user 
					+ " Password: " + password);
			stmt = c.createStatement();
			rs = stmt.executeQuery("select * from beautifulThings.thingsTable");
			while(rs.next()){
				System.out.println("ID: " + rs.getInt("id")
				+" title = " + rs.getString("thing_title")
				+ " desc = " + rs.getString("thing_description")
				+ " rating = " + rs.getInt("thing_rating"));
				b = new BeautifulThing(rs.getInt("id"),rs.getString("thing_title") , rs.getString("thing_description"), rs.getInt("thing_rating"));
				everyone.add(b);
			}
		} catch (SQLException e) {
			System.out.println("Error communicating with the database");
			e.printStackTrace();
		}finally{
			rs.close();
			stmt.close();
			c.close();
		}
		
		return everyone;
	}
	
	public int updateOne(int id, BeautifulThing b) throws SQLException{
		int numberOfRowsAffected = 0;
		String dbURL = "jdbc:mysql://localhost:3307/beautifulThings";
		String user = "root";
		String password = "root";
		Connection c = null;
		PreparedStatement stmt = null;
		int rowsAffected = 0;
		try {
			c= DriverManager.getConnection(dbURL, user, password);
			System.out.println("Connection is successful " + dbURL 
					+ " User: " +  user 
					+ " Password: " + password);
			stmt = c.prepareStatement("update beautifulThings.thingsTable set thing_title = ?, thing_description = ?, thing_value =? where id = ? ");
			stmt.setString(1, b.getThingTitle());
			stmt.setString(2, b.getThingDescription());
			stmt.setInt(3, b.getRating());
			stmt.setInt(4, id);
			rowsAffected = stmt.executeUpdate();
			System.out.println("Rows affected " + rowsAffected);
		} catch (SQLException e) {
			System.out.println("Error communicating with the database");
			e.printStackTrace();
		}finally{
			stmt.close();
			c.close();
		}
		return numberOfRowsAffected;
	}

}
