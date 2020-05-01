package controller;

import org.apache.log4j.Logger;

import scanner.Board;

public enum Actions {
	CREATE ("To create a new item in the database "),
	READ("To view all items in a table"),
	UPDATE("To update an item in the database"),
	DELETE("To delete an item in the database"),
	CALCULATE("To calculate the cost of an order"),
	RETURN("To return to main menu");
	
	
	
	public static final Logger LOGGER = Logger.getLogger(Actions.class);
	
	private String description;
	
	private Actions() {
	}
	
	Actions(String description){
		this.description = description;
		
	}
	public String getDescription() {
		return this.name() +": "+ this.description;
	}
	
	public static void printActions() {
		for(Actions action : Actions.values()) {
			LOGGER.info(action.getDescription());
		}
	}
	
	public static Actions getAction() {
		Actions action;
		while(true) {
			try {
				action = Actions.valueOf(Board.input().toUpperCase());
				break;
			} catch (IllegalArgumentException e) {
				LOGGER.error("Invalid selection, please try again.");
			}
		}
		return action;
	}
	

}
