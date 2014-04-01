package com.example.j2eeapp.commons.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Generic interface for DAO
 * Contains common persistence methods
 * 
 * @author Alex 
 */
public interface GenericDao<T, ID extends Serializable> {
	
	T save(T entity);
	T update(T entity);
	void delete(T entity);
	T findById(ID id);
	List<T> findAll();
	void flush();
	
}
