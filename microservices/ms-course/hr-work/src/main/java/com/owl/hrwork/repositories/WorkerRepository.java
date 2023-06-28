package com.owl.hrwork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.owl.hrwork.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
