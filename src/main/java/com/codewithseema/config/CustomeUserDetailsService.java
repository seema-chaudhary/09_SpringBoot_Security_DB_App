package com.codewithseema.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.codewithseema.entity.Employee;
import com.codewithseema.repository.EmpRepo;

@Component
public class CustomeUserDetailsService implements UserDetailsService {

	@Autowired
	private EmpRepo empRepo; 
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Employee emp = empRepo.findByEmail(email);
		
		if(emp==null)
		{
			throw new UsernameNotFoundException("User Name not found!!!!");
		}else {
			return new CustomUser(emp); 
		}
	
	}

}
