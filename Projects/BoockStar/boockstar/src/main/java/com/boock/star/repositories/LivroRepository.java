package com.boock.star.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.boock.star.doman.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer> {

}
