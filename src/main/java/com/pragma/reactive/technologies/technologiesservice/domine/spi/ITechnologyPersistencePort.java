package com.pragma.reactive.technologies.technologiesservice.domine.spi;

import com.pragma.reactive.technologies.technologiesservice.domine.model.Technology;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

public interface ITechnologyPersistencePort {
    Mono<Technology> save(Technology  tecnology);
    Mono<Technology> findById(Long id);
    Mono<Technology> findByName(String name);
    Flux<Technology> findAll();
}
