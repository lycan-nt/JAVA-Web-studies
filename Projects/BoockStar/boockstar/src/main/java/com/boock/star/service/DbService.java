package com.boock.star.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boock.star.doman.Categoria;
import com.boock.star.doman.Livro;
import com.boock.star.repositories.CategoriaRepository;
import com.boock.star.repositories.LivroRepository;

@Service
public class DbService {
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;
	
	public void instanciaDataBase() {
		Categoria c1 = new Categoria(null, "Informatica", "TI");
		Categoria c2 = new Categoria(null, "História", "Classica");
		
		Livro l1 = new Livro(null, "Clean Code", "Felipe D. Santos", "Lorem ", c1);
		Livro l2 = new Livro(null, "A Arte Da Guerra", "História", "E melhor ser temido do que amado", c2);
		
		c1.getLivros().addAll(Arrays.asList(l1, l2));
		this.categoriaRepository.saveAll(Arrays.asList(c1, c2));
		this.livroRepository.saveAll(Arrays.asList(l1, l2));
	}
}
