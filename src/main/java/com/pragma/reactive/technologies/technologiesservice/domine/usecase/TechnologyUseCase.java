package com.pragma.reactive.technologies.technologiesservice.domine.usecase;

import com.pragma.reactive.technologies.technologiesservice.domine.api.ITechnologyServicePort;
import com.pragma.reactive.technologies.technologiesservice.domine.exception.DomainException;
import com.pragma.reactive.technologies.technologiesservice.domine.model.Technology;
import com.pragma.reactive.technologies.technologiesservice.domine.spi.ITechnologyPersistencePort;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
    public Flux<Technology> findAll(int page, int size, boolean asc) {
        int offset = page * size;
        if (asc) {
            return persistencePort.findAllPagedAsc(size,offset);
        }
        return persistencePort.findAllPagedDesc(size,offset);
    }

    private Mono<Void> validateName(String name){
        return persistencePort.findByName(name)
                .flatMap(tech -> Mono.error(new DomainException("Name already exists")))
                .switchIfEmpty(Mono.defer(() -> {
                    if (name.length() >= 50) {
                        return Mono.error(new DomainException("Name too long"));
                    }
                    return Mono.empty();
                }))
                .then();
    }

    private Mono<Void> validateDescription(String description){
        if (description.length() >= 50){
            throw new DomainException("Description too long");
        }
        return Mono.empty();
    }

}
