package services;

import java.util.List;

import dao.DAO;
import domain.Items;

public class ItemService implements CrudServices<Items>{
private DAO<Items> itemDao;
	
	public ItemService(DAO<Items> itemDao) {
		this.itemDao = itemDao;
	}
	
	public List<Items> view(){
		return itemDao.view();
	}
	
	public Items create(Items items) {
		return itemDao.create(items);
	}
	
	public Items update(Items items) {
		return itemDao.update(items);
	}
	
	public void delete(Long id) {
		itemDao.delete(id);
	}

	@Override
	public Items calculate(Items t) {
		// TODO Auto-generated method stub
		return null;
	}


}
