package com.pragma.reactive.technologies.technologiesservice.infrastructure.output.jpa.repository;

import com.pragma.reactive.technologies.technologiesservice.infrastructure.output.jpa.entity.TechnologyEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ITechnologyRepository extends ReactiveCrudRepository<TechnologyEntity, Long> {
    Mono<TechnologyEntity> findByName(String name);

    @Query("SELECT * FROM technologies ORDER BY name ASC LIMIT :limit OFFSET :offset")
    Flux<TechnologyEntity> findAllPagedAsc(int limit, int offset);

    @Query("SELECT * FROM technologies ORDER BY name DESC LIMIT :limit OFFSET :offset")
    Flux<TechnologyEntity> findAllPagedDesc(int limit, int offset);
}