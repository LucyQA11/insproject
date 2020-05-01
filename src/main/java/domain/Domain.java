package domain;


import org.apache.log4j.Logger;

import scanner.Board;

public enum Domain {
	CUSTOMER(""),
	ITEMS(""),
	ORDERS(""),
	STOP("");
	
	public static final Logger LOGGER = Logger.getLogger(Domain.class);
	
	private String description;
	
	private Domain(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.name();
		
	}
	
	public static void printDomains() {
		for(Domain domain: Domain.values()) {
			LOGGER.info(domain.getDescription());
		}
	}
	
	public static Domain getDomain() {
		Domain domain;
		while (true) {
			try {
				domain = Domain.valueOf(Board.input().toUpperCase());
				break;
			} catch(IllegalArgumentException e) {
				LOGGER.error("Invalid selection please try again");
			}
		}
		return domain;
	}

}
