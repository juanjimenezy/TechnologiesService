package com.pragma.reactive.technologies.technologiesservice.application.handler;

import com.pragma.reactive.technologies.technologiesservice.application.dto.request.TechnologyRequestDTO;
import com.pragma.reactive.technologies.technologiesservice.application.dto.response.TechnologyResponseDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITechnologyHandler {
    Mono<TechnologyResponseDTO> createTechnology(TechnologyRequestDTO technologyRequestDTO);
    Flux<TechnologyResponseDTO> getTechnologies();
    Mono<TechnologyResponseDTO> getTechnology(Long technologyId);
}