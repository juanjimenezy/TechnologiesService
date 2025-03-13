package com.pragma.reactive.technologies.technologiesservice.domine.usecase;

import com.pragma.reactive.technologies.technologiesservice.domine.api.ITechnologyServicePort;
import com.pragma.reactive.technologies.technologiesservice.domine.exception.DomainException;
import com.pragma.reactive.technologies.technologiesservice.domine.model.Technology;
import com.pragma.reactive.technologies.technologiesservice.domine.spi.ITechnologyPersistencePort;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

public class TechnologyUseCase implements ITechnologyServicePort {

    private final ITechnologyPersistencePort persistencePort;

    public TechnologyUseCase(ITechnologyPersistencePort persistencePort) {
        this.persistencePort = persistencePort;
    }

    @Override
    public Mono<Technology> save(Technology technology) {
        return validateName(technology.getName())
                .then(validateDescription(technology.getDescription()))
                .then(Mono.defer(() -> persistencePort.save(technology)));
    }

    @Override
    public Mono<Technology> findById(Long id) {
        return persistencePort.findById(id);
    }

    @Override
    public Flux<Technology> findAll() {
        return persistencePort.findAll();
    }

    private Mono<Void> validateName(String name){
        return persistencePort.findByName(name)
                .flatMap(tech -> Mono.error(new DomainException("Name already exists")))
                .switchIfEmpty(Mono.defer(() -> {
                    if (name.length() >= 50) {
                        return Mono.error(new DomainException("Name too short"));
                    }
                    return Mono.empty();
                }))
                .then();
    }

    private Mono<Void> validateDescription(String description){
        if (description.length() <= 50){
            throw new DomainException("Description too short");
        }
        return Mono.empty();
    }

}
