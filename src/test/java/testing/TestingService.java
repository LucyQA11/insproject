package testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import domain.Customer;
import domain.Items;
import domain.Orders;
import services.CustomerService;
import services.ItemService;
import services.OrderService;

public class TestingService {
	
	private static CustomerService customerService;
	private static Customer customer3;
	private static Customer customer4;
	private static ItemService itemService;
	private static Items item3;
	private static Items item4;
	private static OrderService orderService;
	private static Orders order3;
	private static Orders order4;
	
	@BeforeClass
	public static void customerServiceTesting() {
		customerService = mock(CustomerService.class);
		customer3 = new Customer(3,"John Smith","66 Fredrick Street","john66smith@dandy.com");
		customer4 = new Customer(4, "Janice Doey", "3B Rayners Drive", "janicedoey@dandy.com");
		
	      when(customerService.view()).thenReturn(Arrays.asList(customer3,customer4));
	        when(customerService.create(customer3)).thenReturn(customer3);
	        when(customerService.update(customer4)).thenReturn(customer4);
	          
	        
	    }
	    @Test
	    public void viewAll() {
	        List<Customer> customers = customerService.view();
	 
	        assertNotNull(customers);
	        assertEquals(2, customers.size());
	    } 
	    @Test
	    public void create() {
	        Customer name = customerService.create(customer3);
	    
	        assertNotNull(name);
	        assertEquals(customer3, name); 
	    }
	    
	    @Test
	    public void update() {
	    	Customer address = customerService.update(customer4);
	    	assertNotNull(address);
	    	assertEquals(customer4, address);
	    	  
	      }
	    
	    
	    @BeforeClass
	    public static void itemsTesting() {
	    	 itemService = mock(ItemService.class);
	         item3 = new Items(3, "Cardi tote", 100, 45);
	         item4 = new Items(4, "Frenchie handbag", 50, 100);
	  
	         when(itemService.view()).thenReturn(Arrays.asList(item3,item4));
	         when(itemService.create(item3)).thenReturn(item3);
	         when(itemService.update(item4)).thenReturn(item4);
	    	
	    }
	   
	    @Test
	    public void viewItems() {
	        List<Items> items = itemService.view();
	 
	        assertNotNull(items);
	        assertEquals(2, items.size());
	    }
	    
	    @Test
	    public void createItems() {
	        Items name = itemService.create(item3);
	    
	        assertNotNull(name);
	        assertEquals(item3, name);
	    }
	    
	    @Test
	    public void updateItems() {
	    	Items quantity = itemService.update(item4);
	    	assertNotNull(quantity);
	    	assertEquals(item4, quantity);
	    	  
	      }
	 	    
	    
	    @BeforeClass
	    public static void ordersTesting() {
	    	orderService = mock(OrderService.class);
	    	order3 = new Orders(3,4,3,1,45);
	    	order4 = new Orders(4,3,4,2,200);
	    	
	    	when(orderService.view()).thenReturn(Arrays.asList(order3,order4));
	    	when(orderService.create(order3)).thenReturn(order3);
	    	when(orderService.update(order4)).thenReturn(order4);
	    }
	   
	    @Test
	    public void viewOrders() {
	        List<Orders> orders = orderService.view();
	 
	        assertNotNull(orders);
	        assertEquals(2, orders.size());
	    }
	    @Test
	    public void createOrders() {
	        Orders name = orderService.create(order3);
	 
	        assertNotNull(name);
	        assertEquals(order3, name);
	    }
	    
	    @Test
	    public void updateOrders() {
	    	Orders quantity = orderService.update(order4);
	    	assertNotNull(quantity); 
	    	assertEquals(order4, quantity);
	    	  
	      }
		
	}
	
