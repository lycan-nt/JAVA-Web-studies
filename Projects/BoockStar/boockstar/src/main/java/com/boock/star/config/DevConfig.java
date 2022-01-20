package com.boock.star.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.boock.star.service.DbService;

@Configuration
@Profile("dev")
public class DevConfig {
	@Autowired
	private DbService dbService;
}
