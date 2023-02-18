package com.city.api.Citys.API.cities.resource;

import com.city.api.Citys.API.cities.entities.City;
import com.city.api.Citys.API.cities.repository.ICityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cities")
public class CityResource {
    private final ICityRepository cityRepository;

    public CityResource(ICityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping("")
    public Page<City> cities(final Pageable page){
        return cityRepository.findAll(page);
    }

}
