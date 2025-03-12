package com.pragma.reactive.technologies.technologiesservice.infrastructure.output.jpa.adapter;

import com.pragma.reactive.technologies.technologiesservice.domine.model.Technology;
import com.pragma.reactive.technologies.technologiesservice.domine.spi.ITechnologyPersistencePort;
import com.pragma.reactive.technologies.technologiesservice.infrastructure.output.jpa.mapper.ITechnologyEntityMapper;
import com.pragma.reactive.technologies.technologiesservice.infrastructure.output.jpa.repository.TechnologyRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class TechnologyJpaAdapter implements ITechnologyPersistencePort {

    private final TechnologyRepository technologyRepository;
    private final ITechnologyEntityMapper technologyEntityMapper;


    @Override
    public Mono<Technology> save(Technology tecnology) {
        return null;
    }

    @Override
    public Mono<Technology> findById(Long id) {
        return Mono.empty();
    }

    @Override
    public Mono<Technology> findByName(String name) {
        return Mono.empty();
    }

    @Override
    public Flux<Technology> findAll() {
        return Flux.empty();
    }
}
