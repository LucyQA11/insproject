package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

import domain.Customer;

import java.sql.Statement;



public class CustomerDAO  implements DAO <Customer>{

	public static final Logger LOGGER = Logger.getLogger(CustomerDAO.class);
	
	private String jdbcConnectionURL;
	private String username;
	private String password;
	
	public CustomerDAO(String username, String password) {
		this.jdbcConnectionURL ="jdbc:mysql://10.9.224.3/Bags";
		this.username = username;
		this.password = password;
	} 
	
	public CustomerDAO(String jdbcConnectionURL, String username, String password) {
		this.jdbcConnectionURL = jdbcConnectionURL;
		this.username = username;
		this.password = password;
	}
	
	Customer customerFromResultSet(ResultSet resultSet) throws SQLException{
		Long id = resultSet.getLong("CustomerID");
		String name = resultSet.getString("Name");
		String address = resultSet.getString("Address");
		String email = resultSet.getString("Email");
		return new Customer(id, name, address, email);
			
	}
	
	

	@Override
	public List<Customer> view() {
		try(Connection conn = DriverManager.getConnection(jdbcConnectionURL, username, password);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM Customers");){
			ArrayList<Customer> customers = new ArrayList<>();
			while(rs.next()) {
				customers.add(customerFromResultSet(rs));
			}
			return customers;
		}catch(SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}
	
	
	

	@Override
	public Customer create(Customer customer) {
		try(Connection connection = DriverManager.getConnection(jdbcConnectionURL, username, password);
				Statement stmt = connection.createStatement();){
			stmt.executeUpdate("INSERT INTO Customers (Name, Address, Email) VALUES('" +customer.getName()+"','"+customer.getAddress()+"','"+customer.getEmail()+"');");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	

	@Override
	public Customer update(Customer customer) {
		try(Connection conn = DriverManager.getConnection(jdbcConnectionURL, username, password);
				Statement stmt= conn.createStatement();){
			stmt.executeUpdate("UPDATE Customers SET Address = '"+customer.getAddress()+ "'WHERE CustomerID ="+customer.getId());
			return readCustomer(customer.getId());
		}catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	
	public Customer readCustomer(Long id) {
		try(Connection conn = DriverManager.getConnection(jdbcConnectionURL, username, password);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM Customers WHERE CustomerID ="+id);){
			rs.next();
			return customerFromResultSet(rs);
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
			stmt.executeUpdate("DELETE FROM Customers WHERE CustomerID = " +id);
			
		}catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}
	
	

	public Customer readLatest(){
		try(Connection conn = DriverManager.getConnection(jdbcConnectionURL, username, password);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM Customers ORDER BY CustomerID DESC LIMIT 1");){
			rs.next();
			return customerFromResultSet(rs);
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
