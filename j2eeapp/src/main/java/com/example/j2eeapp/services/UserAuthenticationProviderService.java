package com.example.j2eeapp.services;

import com.example.j2eeapp.domain.UserEntity;

public interface UserAuthenticationProviderService {

	boolean processUserAuthentication(UserEntity user);
	
}
