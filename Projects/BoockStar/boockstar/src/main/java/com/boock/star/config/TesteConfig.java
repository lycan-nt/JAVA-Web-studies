package com.boock.star.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.boock.star.service.DbService;

@Configuration
@Profile("teste")
public class TesteConfig {
	@Autowired
	private DbService dbService;
	
	@Bean
	public void instanciaDataBase() {
		this.dbService.instanciaDataBase();
	}
}
