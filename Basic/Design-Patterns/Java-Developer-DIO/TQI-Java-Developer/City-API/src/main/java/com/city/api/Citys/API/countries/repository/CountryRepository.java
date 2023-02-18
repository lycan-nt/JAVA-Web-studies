package com.city.api.Citys.API.countries.repository;

import com.city.api.Citys.API.countries.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
