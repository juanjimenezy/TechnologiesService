package com.pragma.reactive.technologies.technologiesservice.domine.usecase;

import com.pragma.reactive.technologies.technologiesservice.domine.model.Technology;
import com.pragma.reactive.technologies.technologiesservice.domine.spi.ITechnologyPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
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
}
