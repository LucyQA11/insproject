package domain;

public class Items {
	
	private Long id;
	private String name;
	private int quantity;
	private Double price;
	

	public Items(long id, String name, int quantity, double price) {
		this.id=id;
		this.name=name;
		this.quantity=quantity;
		this.price=price;
	}
	
	public Items(String name, int quantity, double price) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}


	public Items(Long id, int quantity2) {
		this.id = id;
		this.quantity = quantity2;
		
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}
	public String toString() {
		return "id:" +id+" Name: "+name+" Quantity: "+quantity+" Price: "+price;
	}

	
	
	
}
