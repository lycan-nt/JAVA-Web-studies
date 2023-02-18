package com.city.api.Citys.API.staties.repository;

import com.city.api.Citys.API.staties.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStateRepository extends JpaRepository<State, Long> {
}
