package com.pragma.reactive.technologies.technologiesservice.infrastructure.configuration;

import com.pragma.reactive.technologies.technologiesservice.domain.api.ITechnologyServicePort;
import com.pragma.reactive.technologies.technologiesservice.domain.spi.ITechnologyPersistencePort;
import com.pragma.reactive.technologies.technologiesservice.domain.usecase.TechnologyUseCase;
import com.pragma.reactive.technologies.technologiesservice.infrastructure.output.jpa.adapter.TechnologyJpaAdapter;
import com.pragma.reactive.technologies.technologiesservice.infrastructure.output.jpa.mapper.ITechnologyEntityMapper;
import com.pragma.reactive.technologies.technologiesservice.infrastructure.output.jpa.repository.ITechnologyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final ITechnologyRepository technologyRepository;
    private final ITechnologyEntityMapper technologyEntityMapper;

    @Bean
    public ITechnologyPersistencePort technologyPersistencePort() {
        return new TechnologyJpaAdapter(technologyRepository, technologyEntityMapper);
    }

    @Bean
    public ITechnologyServicePort technologyServicePort() {
        return new TechnologyUseCase(technologyPersistencePort());
    }
}
