package com.pragma.reactive.technologies.technologiesservice.domine.usecase;

import com.pragma.reactive.technologies.technologiesservice.domine.exception.DomainException;
import com.pragma.reactive.technologies.technologiesservice.domine.model.Technology;
import com.pragma.reactive.technologies.technologiesservice.domine.spi.ITechnologyPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TechnologyUseCaseTest {

    @Mock
    private ITechnologyPersistencePort persistencePort;

    @InjectMocks
    private TechnologyUseCase technologyUseCase;

    private Technology technology;

    @BeforeEach
    void setUp() {
        technology = new Technology(1L, "Spring WebFlux", "Asynchronous programming framework");
    }

    @Test
    void testSave_Success() {
        when(persistencePort.findByName(technology.getName())).thenReturn(Mono.empty());
        when(persistencePort.save(any(Technology.class))).thenReturn(Mono.just(technology));
        StepVerifier.create(technologyUseCase.save(technology))
                .expectNext(technology)
                .verifyComplete();

        verify(persistencePort).findByName(technology.getName());
        verify(persistencePort).save(technology);
    }

    @Test
    void testSave_NameAlreadyExists() {
        when(persistencePort.findByName(technology.getName())).thenReturn(Mono.just(technology));
        StepVerifier.create(technologyUseCase.save(technology))
                .expectErrorMatches(throwable -> throwable instanceof DomainException
                        && throwable.getMessage().equals("Name already exists"))
                .verify();

        verify(persistencePort).findByName(technology.getName());
        verify(persistencePort, never()).save(any());
    }


    @Test
    void testFindById_Success() {
        when(persistencePort.findById(1L)).thenReturn(Mono.just(technology));
        StepVerifier.create(technologyUseCase.findById(1L))
                .expectNext(technology)
                .verifyComplete();

        verify(persistencePort).findById(1L);
    }

    @Test
    void testFindById_NotFound() {
        when(persistencePort.findById(2L)).thenReturn(Mono.empty());
        StepVerifier.create(technologyUseCase.findById(2L))
                .expectNextCount(0)
                .verifyComplete();
    }

    @Test
    void testFindAll_PagedAsc() {
        when(persistencePort.findAllPagedAsc(10, 0)).thenReturn(Flux.just(technology));
        StepVerifier.create(technologyUseCase.findAll(0, 10, true))
                .expectNext(technology)
                .verifyComplete();
    }


    @Test
    void testSave_NameTooLong() {
        String longName = "A".repeat(50);
        Technology techWithLongName = new Technology(2L, longName, "Valid description");
        when(persistencePort.findByName(longName)).thenReturn(Mono.empty());

        StepVerifier.create(technologyUseCase.save(techWithLongName))
                .expectErrorMatches(throwable -> throwable instanceof DomainException &&
                        throwable.getMessage().equals("Name too long"))
                .verify();

        verify(persistencePort).findByName(longName);
        verify(persistencePort, never()).save(any());
    }

}
