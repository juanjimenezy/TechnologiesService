package com.pragma.reactive.technologies.technologiesservice.domain.api;

import com.pragma.reactive.technologies.technologiesservice.domain.model.Technology;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITechnologyServicePort {
    Mono<Technology> save(Technology technology);
    Mono<Technology> findById(Long id);
    Flux<Technology> findAll(int page, int size, boolean asc);
}
