package dao;

import java.util.List;




public interface DAO<T> {
	
	List<T> view();
	
	T create(T t);
	
	T update(T t);
	
	void delete(Long id);

	int calculate(int id, int proID);




}
