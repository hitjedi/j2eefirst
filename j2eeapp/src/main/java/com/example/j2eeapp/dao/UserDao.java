package com.example.j2eeapp.dao;

import com.example.j2eeapp.commons.dao.GenericDao;
import com.example.j2eeapp.domain.UserEntity;

/**
 * Data access object interface to work with User entity db operations
 * 
 * @author Alex
 */
public interface UserDao extends GenericDao<UserEntity, Long>{

	boolean checkAvailable(String userName);
	
	UserEntity loadUserByUserName(String userName);
	
}
