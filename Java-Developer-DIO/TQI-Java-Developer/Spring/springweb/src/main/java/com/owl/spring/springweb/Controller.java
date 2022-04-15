package com.owl.spring.springweb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/")
	public String mensagem() {
		return "Bora dominar o mundo!";
	}
	
}
