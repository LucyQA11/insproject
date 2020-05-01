package controller;

import java.util.List;

import org.apache.log4j.Logger;

import domain.Customer;
import scanner.Board;
import services.CrudServices;

public class CustomerController implements CrudController<Customer> {
	
	public static final Logger LOGGER = Logger.getLogger(CustomerController.class);
	
	private CrudServices<Customer> CustomerService;
	
	public CustomerController(CrudServices<Customer> customerService) {
		this.CustomerService = customerService;
	}
	
	

	String input() {
		return Board.input();
	}
	
	
	

	@Override
	public Customer create(Customer customer1) {
		LOGGER.info("Please enter your name");
		String name = input();
		LOGGER.info("Please enter your address");
		String address = input();
		LOGGER.info("Please enter your email address");
		String email = input();
		Customer customer = CustomerService.create(new Customer(name, address, email));
		LOGGER.info("Customer created");
		return customer;
		
	}

	@Override
	public List<Customer> view() {
		List<Customer> customers = CustomerService.view();
		for(Customer customer: customers) {
			LOGGER.info(customers.toString());
		}
		return customers;
	}

	@Override
	public Customer update(Customer customer1) {
		LOGGER.info("Enter the ID of the customer you would like to update");
		Long id = Long.valueOf(input());
		LOGGER.info("Please enter new address:");
		String address = input();
		Customer customer = CustomerService.update(new Customer(id,address));
		LOGGER.info("Customer updated.");
		return customer;
		
	}

	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the customer you would like to delete");
		Long id = Long.valueOf(input());
		CustomerService.delete(id);
		LOGGER.info("Customer deleted");
	}



	@Override
	public Customer calculate(Customer customer1) {
		// TODO Auto-generated method stub
		return null;
	}






	






	



	
}
