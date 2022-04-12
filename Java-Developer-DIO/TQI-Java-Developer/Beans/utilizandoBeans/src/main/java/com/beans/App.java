package com.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
		Livro livro = factory.getBean(Livro.class);
		livro.setNome("La casa de codigo");
		livro.setCodigo("1");
		Autor autor = factory.getBean(Autor.class);
		autor.setNome("Felipe D. Santos");
		livro.exibir();
		((AbstractApplicationContext) factory).close();
	}

}
