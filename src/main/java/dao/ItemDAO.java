package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;


import domain.Items;

public class ItemDAO implements DAO<Items>{
	
	
	public static final Logger LOGGER = Logger.getLogger(ItemDAO.class);
	
	private String jdbcConnectionURL;
	private String username;
	private String password;
	
	public ItemDAO(String username, String password) {
		this.jdbcConnectionURL ="jdbc:mysql://34.89.103.5/Bags";
		this.username = username;
		this.password = password;
	}
	
	public ItemDAO(String jdbcConnectionURL, String username, String password) {
		this.jdbcConnectionURL = jdbcConnectionURL;
		this.username = username;
		this.password = password;
	}
	
	Items itemFromResultSet(ResultSet rs) throws SQLException{
		int id = rs.getInt("ProductID");
		String name = rs.getString("ProductName");
		int quantity = rs.getInt("Inventory");
		double price = rs.getDouble("Price");
		return new Items(id, name, quantity,price);
			
	}

	@Override
	public List<Items> view() {
		try(Connection conn = DriverManager.getConnection(jdbcConnectionURL, username, password);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM Products");){
			ArrayList<Items> items = new ArrayList<>();
			while(rs.next()) {
				items.add(itemFromResultSet(rs));
			}
			return items;
		}catch(SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}
		
	@Override
	public Items create(Items items) {
		try(Connection connection = DriverManager.getConnection(jdbcConnectionURL, username, password);
				Statement stmt = connection.createStatement();){
			stmt.executeUpdate("INSERT INTO Products (ProductName, Inventory, Price) VALUES('" +items.getName()+"','"+items.getQuantity()+"','"+items.getPrice()+
					"')");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	

	@Override
	public Items update(Items items) {
		try(Connection conn = DriverManager.getConnection(jdbcConnectionURL, username, password);
				Statement stmt= conn.createStatement();){
			stmt.executeUpdate("UPDATE Products SET Inventory = '"+items.getQuantity()+ "'WHERE ProductID ="+items.getId());
			return readItem(items.getId());
		}catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	
	public Items readItem(Long id) {
		try(Connection conn = DriverManager.getConnection(jdbcConnectionURL, username, password);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM Products WHERE ProductID ="+id);){
			rs.next();
			return itemFromResultSet(rs);
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
			stmt.executeUpdate("DELETE FROM Products WHERE ProductID = " +id);
			
		}catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}
	
	

	public Items readLatest(){
		try(Connection conn = DriverManager.getConnection(jdbcConnectionURL, username, password);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM Products ORDER BY ProductID DESC LIMIT 1");){
			rs.next();
			return itemFromResultSet(rs);
		}catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public int calculate(int id, int proID) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	

	

	
	
	

}
