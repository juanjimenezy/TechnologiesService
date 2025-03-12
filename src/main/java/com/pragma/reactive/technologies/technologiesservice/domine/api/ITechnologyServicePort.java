package com.pragma.reactive.technologies.technologiesservice.domine.api;

import com.pragma.reactive.technologies.technologiesservice.domine.model.Technology;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITechnologyServicePort {
    Mono<Technology> save(Mono<Technology> technology);
    Mono<Technology> findById(Long id);
    Flux<Technology> findAll();
}
