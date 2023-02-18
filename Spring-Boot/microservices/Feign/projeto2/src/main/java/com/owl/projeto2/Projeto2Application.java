package com.owl.projeto2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Projeto2Application {

	public static void main(String[] args) {
		SpringApplication.run(Projeto2Application.class, args);
	}

}
