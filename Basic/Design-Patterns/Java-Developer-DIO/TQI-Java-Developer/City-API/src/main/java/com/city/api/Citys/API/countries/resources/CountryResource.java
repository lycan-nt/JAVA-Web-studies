package com.city.api.Citys.API.countries.resources;

import com.city.api.Citys.API.countries.entities.Country;
import com.city.api.Citys.API.countries.repository.CountryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryResource {

    private CountryRepository repository;

    public CountryResource(CountryRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public Page<Country> countries(Pageable page){
        return repository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCountry(@PathVariable long id) {
        Optional<Country> optionalCountry = repository.findById(id);
        if(optionalCountry.isPresent()){
            return ResponseEntity.ok().body(optionalCountry.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}
