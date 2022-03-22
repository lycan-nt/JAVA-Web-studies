package com.boock.star.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
		Categoria categoria = findById(id);
		categoria.setNome(object.getNome());
		categoria.setDescricao(object.getDescricao());
		return repository.save(categoria);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new com.boock.star.service.exceptions.DataIntegrityViolationException("Categoria não pode ser deletado! Possui livros associados");
		}
	}

}
