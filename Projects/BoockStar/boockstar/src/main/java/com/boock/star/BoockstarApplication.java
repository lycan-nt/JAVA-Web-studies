package com.boock.star;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.boock.star.doman.Categoria;
import com.boock.star.doman.Livro;
import com.boock.star.repositories.CategoriaRepository;
import com.boock.star.repositories.LivroRepository;

@SpringBootApplication
public class BoockstarApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BoockstarApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria c1 = new Categoria(null, "Informatica", "TI");
		Livro l1 = new Livro(null, "Clean Code", "Felipe D. Santos", "Lorem ", c1);
		c1.getLivros().addAll(Arrays.asList(l1));
		this.categoriaRepository.saveAll(Arrays.asList(c1));
		this.livroRepository.saveAll(Arrays.asList(l1));
	}

}
