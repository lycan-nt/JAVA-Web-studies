package com.owl.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.owl.hroauth.entities.User;
import com.owl.hroauth.feignclients.UserFeignClient;



@Service
public class UserService {
	
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

}
