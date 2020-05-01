package services;

import java.util.List;

import dao.DAO;
import domain.Customer;

public class CustomerService implements CrudServices<Customer>{
	
	private DAO<Customer> customerDao;
	
	public CustomerService(DAO<Customer> customerDao) {
		this.customerDao = customerDao;
	} 
	
	public List<Customer> view(){
		return customerDao.view(); 
	}
	
	public Customer create(Customer customer) {
		return customerDao.create(customer);
	}
	
	public Customer update(Customer customer) {
		return customerDao.update(customer);
	}
	
	public void delete(Long id) {
		customerDao.delete(id);
	}

	@Override
	public Customer calculate(Customer t) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
