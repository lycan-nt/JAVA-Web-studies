package com.city.api.Citys.API.staties.resources;

import com.city.api.Citys.API.staties.entities.State;
import com.city.api.Citys.API.staties.repository.IStateRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/staties")
public class StateResource {

    private final IStateRepository repository;

    public StateResource(final IStateRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<State> staties() {
        return repository.findAll();
    }
}
