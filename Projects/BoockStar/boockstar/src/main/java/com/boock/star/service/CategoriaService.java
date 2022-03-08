package com.boock.star.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.boock.star.doman.Categoria;
import com.boock.star.dtos.CategoriaDTO;
import com.boock.star.repositories.CategoriaRepository;
import com.boock.star.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public Categoria findById(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public List<Categoria> findAll() {
		return repository.findAll();
	}
	
	public Categoria create(Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Categoria update(Integer id, CategoriaDTO object) {
		System.out.println("HERE Service");
		Categoria categoria = findById(id);
		System.out.println("Nome: " + object.getNome());
		categoria.setNome(object.getNome());
		categoria.setDescricao(object.getDescricao());
		return repository.save(categoria);
	}

}
