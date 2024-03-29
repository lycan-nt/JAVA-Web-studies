package com.owl.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.owl.hroauth.entities.User;
import com.owl.hroauth.feignclients.UserFeignClient;



@Service
public class UserService implements UserDetailsService{
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	public User findByEmail(String email) {
		User user = this.userFeignClient.findByEmail(email).getBody();
		if (user == null) {
			this.logger.error("Email not found: " + email);
			throw new IllegalArgumentException("Email not found");
		}
		this.logger.info("Email found: " + email);
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(">>>>>>>>>>>>> USER NAME: " + username);
		User user = this.userFeignClient.findByEmail(username).getBody();
		if (user == null) {
			this.logger.error("Email not found: " + username);
			throw new UsernameNotFoundException("Email not found");
		}
		this.logger.info("Email found: " + username);
		return user;
	}

}
