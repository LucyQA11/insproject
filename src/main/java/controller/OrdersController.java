package controller;

import java.util.List;
import org.apache.log4j.Logger;


import domain.Orders;
import scanner.Board;
import services.CrudServices;

public class OrdersController implements CrudController<Orders>{
	
	public static final Logger LOGGER = Logger.getLogger(OrdersController.class);
	
	private CrudServices<Orders> OrderService;
	
	public OrdersController(CrudServices<Orders> orderService) {
		this.OrderService = orderService;
	}
	
	
	
	String input() {
		return Board.input();
	}
	int input2() {
		return Board.input2();
	}
	
	
	

	@Override
	public Orders create(Orders orders) {
		LOGGER.info("Please enter your customer ID");
		String custID = input();
		LOGGER.info("Please enter the item ID");
		String itemID = input();
		LOGGER.info("Please enter the quantity of the item you would like");
		String quantity = input();
		LOGGER.info("Please enter the price");
		int price =input2();
		Orders order = OrderService.create(new Orders(custID, itemID, quantity, price));
		LOGGER.info("Order created");
		return order;
		
	}

	@Override
	public List<Orders> view() {
		List<Orders> orders = OrderService.view();
		for(Orders order: orders) {
			LOGGER.info(order.toString());
		}
		return orders;
	}

	@Override
	public Orders update(Orders orders) {
		LOGGER.info("Enter the ID of the order you would like to update");
		Long id = Long.valueOf(input());
		LOGGER.info("Please enter new quantity:");
		int quantity = input2();
		Orders order = OrderService.update(new Orders(id,quantity));
		LOGGER.info("Order updated.");
		return order;
		
	}

	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long id = Long.valueOf(input());
		OrderService.delete(id);
		LOGGER.info("Order deleted");
	}
	@Override
	public Orders calculate(Orders orders) {
		LOGGER.info("Please enter the ID of the order you would like to calculate");
		Long id = Long.valueOf(input());
		LOGGER.info("Please enter the quantity of your order");
		Long quantity = Long.valueOf(input());
		LOGGER.info("Please enter the price of the item");
		Long price = Long.valueOf(input());
		Long totalprice = quantity*price;
		Orders order = OrderService.calculate(new Orders());
		LOGGER.info("Total price for order "+id+" is "+totalprice);
		return order;
		
	}



	

}
