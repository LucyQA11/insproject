package services;

import java.util.List;


public interface CrudServices<T> {
	
	public List<T> view();
	
	T create (T t);
	
	T update(T t);
	
	void delete(Long id);

	T calculate(T t);
	

}
