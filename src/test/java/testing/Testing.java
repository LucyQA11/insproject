package testing;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import controller.CustomerController;
import controller.ItemsController;
import controller.OrdersController;
import domain.Customer;
import domain.Items; 
import domain.Orders;


public class Testing {
	
    private static CustomerController mockCustomerController;
    private static Customer customer1;
    private static Customer customer2;
    private static ItemsController mockItemsController;
    private static Items item1;
    private static Items item2;
    private static OrdersController mockOrdersController;
    private static Orders order1;
    private static Orders order2;
    
 
    @BeforeClass 
    public static void customerControllerTesting() {
  
        mockCustomerController = mock(CustomerController.class);
        customer1 = new Customer(1, "Bob Smith","23 Driver Lane", "smithbob@dandy.com");
        customer2= new Customer(2, "Jane Doe", "7A Rayners Drive", "janedoe@dandy.com");
 
        when(mockCustomerController.view()).thenReturn(Arrays.asList(customer1,customer2));
        when(mockCustomerController.create(customer1)).thenReturn(customer1);
        when(mockCustomerController.update(customer2)).thenReturn(customer2);
           
        
    }
    @Test
    public void viewAll() {
        List<Customer> allEmployees = mockCustomerController.view();
 
        assertNotNull(allEmployees);
        assertEquals(2, allEmployees.size());
    }  
    @Test
    public void create() {
        Customer customerName = mockCustomerController.create(customer1);
    
        assertNotNull(customerName);
        assertEquals(customer1, customerName);;
    }
    
    
	 


    
    @Test
    public void update() {
    	Customer address =mockCustomerController.update(customer2);
    	assertNotNull(address);
    	assertEquals(customer2, address);
    	  
      }
    
    @BeforeClass
    public static void itemsTesting() {
    	 mockItemsController = mock(ItemsController.class);
         item1 = new Items(1, "Tracy BP", 250, 30);
         item2 = new Items(2, "Sandy clutch", 500, 25);
  
         when(mockItemsController.view()).thenReturn(Arrays.asList(item1,item2));
         when(mockItemsController.create(item1)).thenReturn(item1);
         when(mockItemsController.update(item2)).thenReturn(item2);
    	
    }
   
    @Test
    public void viewItems() {
        List<Items> allItems = mockItemsController.view();
 
        assertNotNull(allItems);
        assertEquals(2, allItems.size());
    }
    
    @Test
    public void createItems() {
        Items itemName = mockItemsController.create(item1);
    
        assertNotNull(itemName);
        assertEquals(item1, itemName);
    }
    
    @Test
    public void updateItems() {
    	Items quantity =mockItemsController.update(item2);
    	assertNotNull(quantity);
    	assertEquals(item2, quantity);;
    	  
      }
  
    
    
    @BeforeClass
    public static void ordersTesting() {
    	mockOrdersController = mock(OrdersController.class);
    	order1 = new Orders(1,1,2,1,25);
    	order2 = new Orders(2,2,1,2,60);
    	
    	when(mockOrdersController.view()).thenReturn(Arrays.asList(order1,order2));
    	when(mockOrdersController.create(order2)).thenReturn(order2);
    	when(mockOrdersController.update(order1)).thenReturn(order1);
    }
   
    @Test
    public void viewOrders() {
        List<Orders> allOrders = mockOrdersController.view();
 
        assertNotNull(allOrders);
        assertEquals(2, allOrders.size());
    }
    @Test
    public void createOrders() {
        Orders orderName = mockOrdersController.create(order2);
 
        assertNotNull(orderName);
        assertEquals(order2, orderName);;
    }
    
    @Test
    public void updateOrders() {
    	Orders quantity =mockOrdersController.update(order1);
    	assertNotNull(quantity); 
    	assertEquals(order1, quantity);;
    	
    	  
      }
    	
    }
    
    
    
	
	
	
	


