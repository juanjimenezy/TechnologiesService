package com.pragma.reactive.technologies.technologiesservice.infrastructure.output.jpa.adapter;

import com.pragma.reactive.technologies.technologiesservice.domain.model.Technology;
import com.pragma.reactive.technologies.technologiesservice.domain.spi.ITechnologyPersistencePort;
import com.pragma.reactive.technologies.technologiesservice.infrastructure.output.jpa.entity.TechnologyEntity;
import com.pragma.reactive.technologies.technologiesservice.infrastructure.output.jpa.mapper.ITechnologyEntityMapper;
import com.pragma.reactive.technologies.technologiesservice.infrastructure.output.jpa.repository.ITechnologyRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class TechnologyJpaAdapter implements ITechnologyPersistencePort {

    private final ITechnologyRepository technologyRepository;
    private final ITechnologyEntityMapper technologyEntityMapper;


    @Override
    public Mono<Technology> save(Technology technology) {
        TechnologyEntity entity = technologyEntityMapper.toTechnologyEntity(technology);
        return technologyRepository.save(entity).map(technologyEntityMapper::toTechnologyModel);
    }

    @Override
    public Mono<Technology> findById(Long id) {
        return technologyRepository.findById(id)
                .map(technologyEntityMapper::toTechnologyModel);
    }

    @Override
    public Mono<Technology> findByName(String name) {
        return technologyRepository.findByName(name)
                .map(technologyEntityMapper::toTechnologyModel);
    }

    @Override
    public Flux<Technology> findAll() {
        return technologyRepository.findAll()
                .map(technologyEntityMapper::toTechnologyModel);
    }

    @Override
    public Flux<Technology> findAllPagedAsc(int limit, int offset) {
        return technologyRepository.findAllPagedAsc(limit, offset)
                .map(technologyEntityMapper::toTechnologyModel);
    }

    @Override
    public Flux<Technology> findAllPagedDesc(int limit, int offset) {
        return technologyRepository.findAllPagedDesc(limit, offset)
                .map(technologyEntityMapper::toTechnologyModel);
    }
}
