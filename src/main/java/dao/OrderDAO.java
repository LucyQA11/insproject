package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;


import domain.Orders;

public class OrderDAO implements DAO<Orders>{
	
	public static final Logger LOGGER = Logger.getLogger(CustomerDAO.class);
	
	private String jdbcConnectionURL;
	private String username;
	private String password;
	
	public OrderDAO(String username, String password) {
		this.jdbcConnectionURL ="jdbc:mysql://10.9.224.3/Bags";
		this.username = username;
		this.password = password;
	}
	
	public OrderDAO(String jdbcConnectionURL, String username, String password) {
		this.jdbcConnectionURL = jdbcConnectionURL;
		this.username = username;
		this.password = password;
	}
	
	Orders ordersFromResultSet(ResultSet rs) throws SQLException{
		int id = rs.getInt("OrderID");
		int custID = rs.getInt("CustomerID");
		int proID = rs.getInt("ProductID");
		int quantity = rs.getInt("Quantity");
		int tPrice = rs.getInt("TotalPrice");
		return new Orders(id,custID,proID,quantity,tPrice);
			
	}
	
	

	@Override
	public List<Orders> view() {
		try(Connection conn = DriverManager.getConnection(jdbcConnectionURL, username, password);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM Orders");){
			ArrayList<Orders> orders = new ArrayList<>();
			while(rs.next()) {
				orders.add(ordersFromResultSet(rs));
			}
			return orders;
		}catch(SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}
	
	
	

	@Override
	public Orders create(Orders orders) {
		try(Connection connection = DriverManager.getConnection(jdbcConnectionURL, username, password);
				Statement stmt = connection.createStatement();){
			stmt.execute("INSERT INTO Orders (CustomerID, ProductID, Quantity, TotalPrice) VALUES('" +orders.getCustID()+"','"+orders.getProID()+"','"+orders.getQuantity()+"','"+orders.gettPrice()+"');");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	

	@Override
	public Orders update(Orders orders) {
		try(Connection conn = DriverManager.getConnection(jdbcConnectionURL, username, password);
				Statement stmt= conn.createStatement();){
			stmt.executeUpdate("UPDATE Orders SET Quantity = '"+orders.getQuantity()+ "'WHERE OrderID="+orders.getId());
			return readOrder((long) orders.getId());
		}catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}
			
		
	public Orders readOrder(Long id) {
		try(Connection conn = DriverManager.getConnection(jdbcConnectionURL, username, password);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM Orders WHERE OrderID ="+id);){
			rs.next();
			return ordersFromResultSet(rs);
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
		return null;
	}
	
	
	@Override
	public void delete(Long id) {
		try(Connection conn = DriverManager.getConnection(jdbcConnectionURL, username, password);
				Statement stmt= conn.createStatement();){
			stmt.executeUpdate("DELETE FROM Orders WHERE OrderID = " +id);
			
		}catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}
	
	

	public Orders readLatest(){
		try(Connection conn = DriverManager.getConnection(jdbcConnectionURL, username, password);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM Orders ORDER BY OrderID DESC LIMIT 1");){
			rs.next();
			return ordersFromResultSet(rs);
		}catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	@Override
	public int calculate(int id, int ProID) {
		
		String sql = "SELECT Price FROM Products WHERE ProductID= " + ProID;
		String sql2 = "SELECT Quantity FROM Orders WHERE OrderID= " +id;
		int price =0;
		int quantity =0;
		try(Connection conn = DriverManager.getConnection(jdbcConnectionURL, username, password);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				ResultSet rs2 = stmt.executeQuery(sql2);){
			while (rs.next()) {
				price = rs.getInt("Price");
			}
			while (rs2.next()) {
				quantity = rs2.getInt("Quantity");
			}
			
			
		}catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		int totalPrice = quantity*price;
		return totalPrice;
		
		
		
	}

	

	
       
   
       
      
}
