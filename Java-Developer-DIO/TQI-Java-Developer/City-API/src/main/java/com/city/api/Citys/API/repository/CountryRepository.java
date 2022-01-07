package com.city.api.Citys.API.repository;

import com.city.api.Citys.API.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
