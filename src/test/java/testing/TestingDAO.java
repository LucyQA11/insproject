package testing;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import dao.CustomerDAO;
import dao.ItemDAO;
import dao.OrderDAO;
import domain.Customer;
import domain.Items;
import domain.Orders;

public class TestingDAO {
	
	private static CustomerDAO customerDAO;
	private static Customer cust1;
	private static Customer cust2;
	private static ItemDAO itemDAO;
	private static Items item1;
	private static Items item2;
	private static OrderDAO orderDAO;
	private static Orders order1;
	private static Orders order2;
	
	@BeforeClass
	public static void customerDaoTesting() {
		customerDAO = mock(CustomerDAO.class);
		cust1 = new Customer(1,"Bob Smith","23 Driver Lane","smithbob@dandy.com");
		cust2 = new Customer(2, "Jane Doe", "7A Rayner Drive", "janedoe@dandy.com");
		
		when(customerDAO.view()).thenReturn(Arrays.asList(cust1,cust2));
		when(customerDAO.create(cust2)).thenReturn(cust2);
		when(customerDAO.update(cust1)).thenReturn(cust1);
	} 
	@Test
	public void viewCustomer(){
		List<Customer> customer = customerDAO.view();
		assertNotNull(customer);
		assertEquals(2, customer.size());	
	}
	
	@Test
	public void createCustomer(){
		Customer name = customerDAO.create(cust2);
		assertNotNull(name);
		assertEquals(cust2, name);	
	}
	
	@Test
	public void updateCustomer(){
	Customer address = customerDAO.update(cust1);
	assertNotNull(address);
	assertEquals(cust1, address);
	
	}
	
	
	@BeforeClass
	public static void itemsDaoTesting() {
		itemDAO = mock(ItemDAO.class);
		item1 = new Items(1, "Tracy BP", 250, 30);
		item2 = new Items(2, "Sandy Clutch", 500, 25);
		
		when(itemDAO.view()).thenReturn(Arrays.asList(item1, item2));
		when(itemDAO.create(item1)).thenReturn(item1);
		when(itemDAO.update(item2)).thenReturn(item2);
	}
	  @Test
	    public void viewItems() {
	        List<Items> items = itemDAO.view();
	 
	        assertNotNull(items);
	        assertEquals(2, items.size());
	    }
	    
	    @Test
	    public void createItems() {
	        Items name = itemDAO.create(item1);
	    
	        assertNotNull(name);
	        assertEquals(item1, name);
	    }
	    
	    @Test
	    public void updateItems() {
	    	Items quantity = itemDAO.update(item2);
	    	assertNotNull(quantity);
	    	assertEquals(item2, quantity);
	    	  
	      }
	
	

	@BeforeClass
	public static void ordersDaoTesting() {
		orderDAO = mock(OrderDAO.class);
		order1 = new Orders(1,1,2,1,25);
		order2 = new Orders(2,2,1,2,60);
		
		when(orderDAO.view()).thenReturn(Arrays.asList(order1,order2));
    	when(orderDAO.create(order2)).thenReturn(order2);
    	when(orderDAO.update(order1)).thenReturn(order1);	
		
	}
	
	   @Test
	    public void viewOrders() {
	        List<Orders> orders = orderDAO.view();
	 
	        assertNotNull(orders);
	        assertEquals(2, orders.size());
	    }
	    @Test
	    public void createOrders() {
	        Orders name = orderDAO.create(order2);
	 
	        assertNotNull(name);
	        assertEquals(order2, name);
	    }
	    
	    @Test
	    public void updateOrders() {
	    	Orders quantity = orderDAO.update(order1);
	    	assertNotNull(quantity);
	    	assertEquals(order1, quantity);
	    	  
	      }
	
}
