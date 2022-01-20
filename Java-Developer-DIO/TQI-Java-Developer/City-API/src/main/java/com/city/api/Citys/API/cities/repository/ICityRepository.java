package com.city.api.Citys.API.cities.repository;

import com.city.api.Citys.API.cities.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICityRepository extends JpaRepository<City, Long> {
}
