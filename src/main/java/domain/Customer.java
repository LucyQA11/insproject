package domain;

public class Customer {
	
	private Long id;
	private String name;
	private String address;
	private String email;
	
	public Customer(String name, String address, String email) {
		this.name = name;
		this.address = address;
		this.email = email;
	}
	
	public Customer(int i, String name, String address, String email) {
		this.name = name;
		this.address = address;
		this.email = email;	
	}

	public Customer(Long id, String address) {
		this.id=id;
		this.address = address;
		
	}
	public Customer(Long id, String name, String address, String email) {
		this.id =id;
		this.name = name;
		this.address =address;
		this.email =email;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		return "id:" +id+" Name: "+name+" Address: "+address+" Email: "+email;
	}
	
	

	
}
