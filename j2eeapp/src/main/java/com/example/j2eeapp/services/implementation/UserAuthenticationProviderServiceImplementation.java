package com.example.j2eeapp.services.implementation;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.j2eeapp.domain.UserEntity;

public class UserAuthenticationProviderServiceImplementation implements com.example.j2eeapp.services.UserAuthenticationProviderService {
	
	private AuthenticationManager authenticationManager;
	
	@Override
	public boolean processUserAuthentication(UserEntity user) {

		try{
			
			Authentication request = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
			Authentication result = authenticationManager.authenticate(request);
			SecurityContextHolder.getContext().setAuthentication(result);
			return true;
			
		} catch(AuthenticationException ae){

			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, ae.getMessage(), "Sorry!"));
			return false;
			
		}
		
	}

	public AuthenticationManager getAuthenticationManager() {
		return authenticationManager;
	}

	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	
}
