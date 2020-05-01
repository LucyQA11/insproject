package scanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;

import controller.Actions;
import controller.CrudController;
import controller.CustomerController;
import controller.ItemsController;
import controller.OrdersController;
import dao.CustomerDAO;
import dao.ItemDAO;
import dao.OrderDAO;
import domain.Domain;
import services.CustomerService;
import services.ItemService;
import services.OrderService;

public class InventorySystem {
	
	
	public static final Logger LOGGER = Logger.getLogger(InventorySystem.class);
	
	public void inventory() {
		LOGGER.info("Username: ");
		String username = Board.input();
		LOGGER.info("Password: ");
		String password = Board.input();
		
		init(username, password);
		
		LOGGER.info("Where would you like to go?");
		Domain.printDomains();
		
		Domain domain = Domain.getDomain();
		LOGGER.info("What would you like to do?");
		
		Actions.printActions();
		Actions action = Actions.getAction();
		
		switch(domain) {
		case CUSTOMER:
			CustomerController customerController = new CustomerController(
					new CustomerService(new CustomerDAO(username, password)));
			doAction(customerController, action);
			LOGGER.info("Where would you like to go?");
			Domain.printDomains();
			
			Domain domain1 = Domain.getDomain();
			LOGGER.info("What would you like to do?");
			
			Actions.printActions();
			Actions domain2 = Actions.getAction();
			break;
		case ITEMS:
			ItemsController itemController = new ItemsController(
					new ItemService(new ItemDAO(username, password)));
			doAction(itemController, action);
			LOGGER.info("Where would you like to go?");
			Domain.printDomains();
			
			Domain domain3 = Domain.getDomain();
			LOGGER.info("What would you like to do?");
			
			Actions.printActions();
			Actions domain4 = Actions.getAction();
			break;
		case ORDERS:
			OrdersController orderController = new OrdersController(
					new OrderService(new OrderDAO(username, password)));
			doAction(orderController, action);
			LOGGER.info("Where would you like to go?");
			Domain.printDomains();
			
			Domain domain5 = Domain.getDomain();
			LOGGER.info("What would you like to do?");
			
			Actions.printActions();
			Actions domain6 = Actions.getAction();
			break;
		case STOP:
			LOGGER.info("Goodbye");
			break;
		default:
			break;
		}
		
		
	}
	
	
	
	public void doAction(CrudController<?> crudController, Actions action) {
		switch(action){
		case CREATE:
			crudController.create(null);
 
			LOGGER.info("Where would you like to go?");
			Domain.printDomains();
			
			Domain domain7 = Domain.getDomain();
			LOGGER.info("What would you like to do?");
			
			Actions.printActions();
			Actions domain8 = Actions.getAction();
			crudController.create(null);

			
			break;
			
		case READ:
			crudController.view();
			LOGGER.info("Where would you like to go?");
			Domain.printDomains();
			
			Domain domain9 = Domain.getDomain();
			LOGGER.info("What would you like to do?");
			
			Actions.printActions();
			Actions domain10 = Actions.getAction();
			crudController.view();
			
			break;
			
		case UPDATE:
			crudController.update(null);
			LOGGER.info("Where would you like to go?");
			Domain.printDomains();
			
			Domain domain11 = Domain.getDomain();
			LOGGER.info("What would you like to do?");
			
			Actions.printActions();
			Actions domain12 = Actions.getAction();
			crudController.update(null);
			break;
			
		case DELETE:
			crudController.delete();
			LOGGER.info("Where would you like to go?");
			Domain.printDomains();
			
			Domain domain13 = Domain.getDomain();
			LOGGER.info("What would you like to do?");
			
			Actions.printActions();
			Actions doman14 = Actions.getAction();
			crudController.delete();
			break;
			
		case CALCULATE:
			crudController.calculate(null);
			LOGGER.info("Where would you like to go?");
			Domain.printDomains();
			
			Domain domain15 = Domain.getDomain();
			LOGGER.info("What would you like to do?");
			
			Actions.printActions();
			Actions domain16 = Actions.getAction();
			crudController.calculate(null);
			break;
			
		case RETURN:
			break;
		default:
			break;
		}
		}
	
	
	public void init(String username, String password) {
		init("jdbc:mysql://"+ Board.MYSQL_URL +"/", username, password, "src/main/resources/sql-schema.sql");	
		
	}
	
	public String readFile(String fileLocation) {
		StringBuilder stringBuilder = new StringBuilder();
		try(BufferedReader br = new BufferedReader(new FileReader(fileLocation));){
			String string;
			while((string = br.readLine()) !=null) {
				stringBuilder.append(string);
				stringBuilder.append("\r\n");
			}
		}catch (IOException e) {
			for (StackTraceElement ele: e.getStackTrace()) {
				LOGGER.debug(ele);
			}
			LOGGER.error(e.getMessage());
		}
		return stringBuilder.toString();
		}
	
	public void init(String jdbcConnectionURL, String username, String password, String fileLocation) {
		try(Connection connection = DriverManager.getConnection(jdbcConnectionURL, username, password);
				BufferedReader br = new BufferedReader(new FileReader(fileLocation));){
			String string;
			while((string = br.readLine())!=null) {
				try(java.sql.Statement statement = connection.createStatement();){
					statement.executeUpdate(string);
				}
			}
		}catch (SQLException | IOException e) {
			for(StackTraceElement ele : e.getStackTrace()) {
				LOGGER.debug(ele);
			}
			LOGGER.error(e.getMessage());
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
