package databases;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import beans.Order;

@Stateless
@Local(DataAccessInterface.class)
@LocalBean
public class OrdersDataService implements DataAccessInterface {
	// Class for accessing the Database of Orders
	
	
	/*
	 * Default constructor.
	 */
	public OrdersDataService() {
	}
	
	// Method to return all orders from the database
	@Override
	public List<Order> getOrders() {
		// List to hold all Orders from the database
		List<Order> orderList = new ArrayList<Order>();
		// A string containing the URL of the database
		String url = "jdbc:postgresql://localhost:5432/postgres";
		// String with the database login username
		String username = "postgres";
		// String with the database login password
		String password = "root";
		// A connection object to connect to the database
		Connection conn = null;

		// A try catch statement to connect to the database
		try {
			// Set connection class to connect to local database
			conn = DriverManager.getConnection(url, username, password);
			// Message to verify connection success to database
			System.out.println("Success!!");
			// Statement object set to Connection object createStatement
			Statement stmt = conn.createStatement();
			// String with SQL statement requesting all items in the testapp.orders table
			String sqlStmt = "SELECT * FROM testapp.orders";
			// ResultSet object set to hold the results of the Statements execution of the
			// query
			ResultSet rs = stmt.executeQuery(sqlStmt);

			// Step through the ResultSet and print each items ID, Product name, and Price
			// to the console
			while (rs.next()) {
				orderList.add(new Order(rs.getInt("id"), rs.getString("order_no"), rs.getString("product_name"), rs.getFloat("price"), rs.getInt("quantity")));
				
			}
			// Close the ResultSet
			rs.close();
			// Close the Statement
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Failure!!");
			e.printStackTrace();
		} finally {
			// Check for connection and close the database if one is found
			if (!conn.equals(null)) {
				try {
					conn.close();
					System.out.println("Connection closed");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return orderList;
	}

	// Method to insert a new order into the testapp.orders database
	public void insertOrder(Order order) {
		// A string containing the URL of the database
		String url = "jdbc:postgresql://localhost:5432/postgres";
		// String with the database login username
		String username = "postgres";
		// String with the database login password
		String password = "root";
		// A connection object to connect to the database
		Connection conn = null;

		try {
			// Set connection class to connect to local database
			conn = DriverManager.getConnection(url, username, password);
			// Message to verify connection success to database
			System.out.println("Success!!");
			// PreparedStatement object
			PreparedStatement stmt = null;
			//SQL statement that inserts new order into testapp.orders database
			stmt = conn.prepareStatement("INSERT INTO  testapp.ORDERS(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES(?, ?, ?, ?)");
			// Convert Order price to Bigdecimal so it can be put into the database
			BigDecimal price = new BigDecimal(Float.toString(order.getPrice()));
			// Set stmt variables for insertion into database
			stmt.setString(1, order.getOrderNumber());
			stmt.setString(2, order.getProductName());
			stmt.setBigDecimal(3, price);
			stmt.setInt(4, order.getQuantity());			
			// Execute insertion of order into database
			stmt.executeUpdate();
			// Close out statement
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Check for connection and close the database if one is found
			if (!conn.equals(null)) {
				try {
					conn.close();
					System.out.println("Connection closed");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	
}
