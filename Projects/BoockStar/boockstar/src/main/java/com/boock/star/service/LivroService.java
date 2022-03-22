package com.boock.star.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boock.star.doman.Livro;
import com.boock.star.repositories.LivroRepository;
import com.boock.star.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository repository;

	public Livro findById(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Livro não encontrado ID: " + id + ", Tipo: " + Livro.class.getName()));
	}
	
}
