package com.pragma.reactive.technologies.technologiesservice.infrastructure.output.jpa.adapter;

import com.pragma.reactive.technologies.technologiesservice.domine.model.Technology;
import com.pragma.reactive.technologies.technologiesservice.domine.spi.ITechnologyPersistencePort;
import com.pragma.reactive.technologies.technologiesservice.infrastructure.output.jpa.entity.TechnologyEntity;
import com.pragma.reactive.technologies.technologiesservice.infrastructure.output.jpa.mapper.ITechnologyEntityMapper;
import com.pragma.reactive.technologies.technologiesservice.infrastructure.output.jpa.repository.TechnologyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class TechnologyJpaAdapter implements ITechnologyPersistencePort {

    private final TechnologyRepository technologyRepository;
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
}
