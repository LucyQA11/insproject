package domain;

public class Orders {
	
	private int id;
	private int custID;
	private int proID;
	private int quantity;
	private int tPrice;
	private Orders quantity2;
	
	
	public Orders(int id, int custID, int proID, int quantity, int tPrice) {
		this.id= id;
		this.custID = custID;
		this.proID = proID;
		this.quantity = quantity;
		this.tPrice = tPrice;
		
	}

	public Orders(String custID3, String itemID, String quantity3) {
	
	}

	public Orders(Long id2, String quantity2) {
		// TODO Auto-generated constructor stub
	}

	public Orders(String custID2, String itemID, String quantity2, String price) {
		// TODO Auto-generated constructor stub
	}

	public Orders() {
		// TODO Auto-generated constructor stub
	}

	public Orders(String custID2, String itemID, String quantity2, int price) {
		// TODO Auto-generated constructor stub
	}

	public Orders(Long id2, int quantity2) {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public int getProID() {
		return proID;
	}

	public void setProID(int proID) {
		this.proID = proID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int gettPrice() {
		return tPrice;
	}

	public void settPrice(int tPrice) {
		this.tPrice = tPrice;
	}
	
	public String toString() {
		return "Order ID:" +id+" Customer ID: "+proID+" Quantity: "+quantity+" Total: "+tPrice;
	}

}
