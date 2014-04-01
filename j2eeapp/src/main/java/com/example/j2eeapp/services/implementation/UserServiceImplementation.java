package com.example.j2eeapp.services.implementation;

import com.example.j2eeapp.dao.UserDao;
import com.example.j2eeapp.domain.UserEntity;
import com.example.j2eeapp.services.UserService;

/**
 * 
 * @author Alex
 */
public class UserServiceImplementation implements UserService{

	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	
	/**
     * Create user - persist to database
     * 
     * @param userEntity
     * @return true if success
     */
	public boolean createUser(UserEntity userEntity){
		
		userDao.save(userEntity);
		return true;
		
	}
	
}
