package com.pragma.reactive.technologies.technologiesservice.infrastructure.configuration;

import com.pragma.reactive.technologies.technologiesservice.domine.api.ITechnologyServicePort;
import com.pragma.reactive.technologies.technologiesservice.domine.spi.ITechnologyPersistencePort;
import com.pragma.reactive.technologies.technologiesservice.domine.usecase.TechnologyUseCase;
import com.pragma.reactive.technologies.technologiesservice.infrastructure.output.jpa.adapter.TechnologyJpaAdapter;
import com.pragma.reactive.technologies.technologiesservice.infrastructure.output.jpa.mapper.ITechnologyEntityMapper;
import com.pragma.reactive.technologies.technologiesservice.infrastructure.output.jpa.repository.TechnologyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final TechnologyRepository technologyRepository;
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
