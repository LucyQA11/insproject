package controller;

import java.util.List;
import org.apache.log4j.Logger;

import domain.Items;
import scanner.Board;
import services.CrudServices;

public class ItemsController implements CrudController<Items>{
	
public static final Logger LOGGER = Logger.getLogger(ItemsController.class);
	
	private CrudServices<Items> ItemService;
	
	public ItemsController(CrudServices<Items> itemService) {
		this.ItemService = itemService;
	}
	
	String input() {
		return Board.input();
	}
	int input2() {
		return Board.input2();
	}

	@Override
	public List<Items> view() {
		List<Items> items = ItemService.view();
		for(Items item: items) {
			LOGGER.info(items.toString());
		}
		return items;
	}
	
	@Override
	public Items create(Items item1) {
		LOGGER.info("Please enter item name");
		String name = input();
		LOGGER.info("Please enter quantity");
		int quantity = input2();
		LOGGER.info("Please enter your products price");
		double price = input2();
		Items item = ItemService.create(new Items(name, quantity, price));
		LOGGER.info("Item created");
		return item;
		
	}

	@Override
	public Items update(Items item1) {
		LOGGER.info("Enter the ID of the item you would like to update");
		Long id = Long.valueOf(input());
		LOGGER.info("Please enter new quantity");
		int quantity = input2();
		Items item = ItemService.update(new Items(id, quantity));
		LOGGER.info("Item updated.");
		return item;
		
	}

	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the customer you would like to delete");
		Long id = Long.valueOf(input());
		ItemService.delete(id);
		LOGGER.info("Item deleted");
	}

	@Override
	public Items calculate(Items item) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
