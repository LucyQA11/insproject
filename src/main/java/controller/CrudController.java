package controller;

import java.util.List;

public interface CrudController<T> {
	List<T> view();
	T create(T t);
	T update(T t);
	void delete();
	T calculate(T t);
	
}