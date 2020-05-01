package services;

import java.util.List;

import dao.DAO;
import domain.Orders;

public class OrderService implements DAO<Orders>, CrudServices<Orders>{
private DAO<Orders> orderDao;
	
	public OrderService(DAO<Orders> orderDao) {
		this.orderDao = orderDao;
	}
	
	public List<Orders> view(){
		return orderDao.view();
	}
	
	public Orders create(Orders orders) {
		return orderDao.create(orders);
	}
	
	public Orders update(Orders orders) {
		return orderDao.update(orders);
	}
	
	public void delete(Long id) {
		orderDao.delete(id);
	}

	@Override
	public Orders calculate(Orders t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int calculate(int id, int proID) {
		// TODO Auto-generated method stub
		return orderDao.calculate(id, proID);
	}

	

	
	

	

	

}
