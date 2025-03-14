package com.pragma.reactive.technologies.technologiesservice.application.handler;

import com.pragma.reactive.technologies.technologiesservice.application.dto.request.TechnologyRequestDTO;
import com.pragma.reactive.technologies.technologiesservice.application.dto.response.TechnologyResponseDTO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface ITechnologyHandler {
    Mono<TechnologyResponseDTO> createTechnology(TechnologyRequestDTO technologyRequestDTO);
    Flux<TechnologyResponseDTO> getTechnologies(int page, int size, boolean asc);
    Mono<TechnologyResponseDTO> getTechnology(Long technologyId);
}