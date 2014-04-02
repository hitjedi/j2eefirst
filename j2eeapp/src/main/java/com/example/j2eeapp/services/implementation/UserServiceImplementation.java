package com.example.j2eeapp.services.implementation;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.j2eeapp.dao.UserDao;
import com.example.j2eeapp.domain.UserEntity;
import com.example.j2eeapp.services.UserService;

/**
 * 
 * @author Alex
 */
public class UserServiceImplementation implements UserService, UserDetailsService {

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

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		UserEntity user = userDao.loadUserByUserName(userName);

		if(user == null) {
			
			throw new UsernameNotFoundException(String.format("No such user '%s'", userName));
			
		}
		
		Collection<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
		auth.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		User userDetails = new User(user.getUserName(), user.getPassword(), auth);
		return userDetails;
	
	}
	
}
