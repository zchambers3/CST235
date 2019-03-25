package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.NewSite;

@Stateless
@Local
@Alternative
public class DatabaseService implements DatabaseInterface{

	//CRUD operations
	String dbURL = "jdbc:mysql://localhost:3306";
	String user = "root";
	String password = "root";
	
	public int deleteOne(int id) {
		int numberOfRowsAffected = 0;
		
		Connection c = null;
		PreparedStatement stmt = null;
		int rowsAffected = 0;
		
		try {
			c = DriverManager.getConnection(dbURL, user, password);
			System.out.println("Connection successful " + dbURL + " user = " + user);
			
			//create a SQL statement
			stmt = c.prepareStatement("delete from  NewSites where id = ?");
			stmt.setInt(1, id);
			
			//execute the statement			
			rowsAffected = stmt.executeUpdate();			
			
			System.out.println("Rows affected " + rowsAffected);
			
		} catch (SQLException e) {
			System.out.println("Error communicating with the database");
			e.printStackTrace();
		} finally {
			//close connection to database
			
			try {
				stmt.close();
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}		
				
		return numberOfRowsAffected;
	}
	
	public int insertOne(NewSite b) {
		int numberOfRowsAffected = 0;
		
		Connection c = null;
		PreparedStatement stmt = null;
		int rowsAffected = 0;
		
		try {
			c = DriverManager.getConnection(dbURL, user, password);
			System.out.println("Connection successful " + dbURL + " user = " + user);
			
			//create a SQL statement
			stmt = c.prepareStatement("insert into NewSites (id, type, title, status, releasedate, users) values (null, ?, ?, ?, ?, ?)");
			stmt.setString(1, b.getType());			//NEED TO EDIT & UPDATE
			stmt.setString(2, b.getTitle());		//NEED TO EDIT & UPDATE
			stmt.setString(3, b.getStatus());		//NEED TO EDIT & UPDATE
			stmt.setString(4, b.getRelease());		//NEED TO EDIT & UPDATE
			stmt.setString(5, b.getCreators());		//NEED TO EDIT & UPDATE
			
			//execute the statement			
			rowsAffected = stmt.executeUpdate();
			
			System.out.println("Rows affected " + rowsAffected);
			
		} catch (SQLException e) {
			System.out.println("Error communicating with the database");
			e.printStackTrace();
		} finally {
			//close connection to database
			
			try {
				stmt.close();
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

		return numberOfRowsAffected;
	}
	
	public ArrayList<NewSite> readAll() {
		ArrayList<NewSite> everyone = new ArrayList<>();
		NewSite b;
		
		Connection c = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			c = DriverManager.getConnection(dbURL, user, password);
			System.out.println("Connection successful " + dbURL + " user = " + user);
			
			//create a SQL statement
			stmt = c.createStatement();
			
			//execute the statement			
			rs = stmt.executeQuery("select * from  NewSites");
			
			//process the rows in the result set
			while(rs.next()) {
				b = new NewSite(rs.getInt("id"), rs.getString("type"), rs.getString("title"), rs.getString("status"), rs.getString("releasedate"), rs.getString("users"));
				everyone.add(b);
			}
			
		} catch (SQLException e) {
			System.out.println("Error communicating with the database");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return everyone;
	}
	
	public int updateOne(int id, NewSite b) {
		int numberOfRowsAffected = 0;
		
		Connection c = null;
		PreparedStatement stmt = null;
		int rowsAffected = 0;
		
		try {
			c = DriverManager.getConnection(dbURL, user, password);
			System.out.println("Connection successful " + dbURL + " user = " + user);
			
			//create a SQL statement
			stmt = c.prepareStatement("update  NewSites set type = ?, title = ?, status = ?, releasedate = ?, users = ? where id = ? ");
			stmt.setString(1, b.getType());  		//NEED TO EDIT AND UPDATE
			stmt.setString(2, b.getTitle());		//NEED TO EDIT AND UPDATE
			stmt.setString(3, b.getStatus());		//NEED TO EDIT AND UPDATE
			stmt.setString(4, b.getRelease());		//NEED TO EDIT AND UPDATE
			stmt.setString(5, b.getCreators());		//NEED TO EDIT AND UPDATE
			stmt.setInt(6, id);
			
			//execute the statement			
			rowsAffected = stmt.executeUpdate();
			
			System.out.println("Rows affected " + rowsAffected);
			
		} catch (SQLException e) {
			System.out.println("Error communicating with the database");
			e.printStackTrace();
		} finally {
			//close connection to database
			
			try {
				stmt.close();
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return numberOfRowsAffected;
	}

	@Override
	public NewSite getThingById(int thingnumber) {
		NewSite b = null;
		
		Connection c = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			c = DriverManager.getConnection(dbURL, user, password);
			System.out.println("Connection successful " + dbURL + " user = " + user);
			
			//create a SQL statement
			stmt = c.prepareStatement("select * from  NewSites WHERE id = ?");
			stmt.setInt(1, thingnumber);
			
			rs = stmt.executeQuery();
			
			//process the rows in the result set
			while(rs.next()) {
				b = new NewSite(rs.getInt("id"), rs.getString("type"), rs.getString("title"), rs.getString("status"), rs.getString("releasedate"), rs.getString("users"));
			}
			
		} catch (SQLException e) {
			System.out.println("Error communicating with the database");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return b;
	}

	@Override
	public ArrayList<NewSite> searchByName(String searchname) {
		ArrayList<NewSite> everyone = new ArrayList<>();
		NewSite b = null;
		
		Connection c = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			c = DriverManager.getConnection(dbURL, user, password);
			System.out.println("Connection successful " + dbURL + " user = " + user);
			
			//create a SQL statement
			stmt = c.prepareStatement("select * from  NewSites WHERE title LIKE ?");
			stmt.setString(1, "%" + searchname + "%");
			
			rs = stmt.executeQuery();
			
			//process the rows in the result set
			while(rs.next()) {
				b = new NewSite(rs.getInt("id"), rs.getString("type"), rs.getString("title"), rs.getString("status"), rs.getString("releasedate"), rs.getString("users"));
				everyone.add(b);
			}
			
		} catch (SQLException e) {
			System.out.println("Error communicating with the database");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return everyone;
	}
	
}