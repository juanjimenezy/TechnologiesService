package com.pragma.reactive.technologies.technologiesservice.application.handler;

import com.pragma.reactive.technologies.technologiesservice.application.dto.request.TechnologyRequestDTO;
import com.pragma.reactive.technologies.technologiesservice.application.dto.response.TechnologyResponseDTO;
import com.pragma.reactive.technologies.technologiesservice.application.mapper.ITechnologyRequestMapper;
import com.pragma.reactive.technologies.technologiesservice.application.mapper.ITechnologyResponseMapper;
import com.pragma.reactive.technologies.technologiesservice.domine.api.ITechnologyServicePort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TechnologyHandler implements ITechnologyHandler {
    private final ITechnologyServicePort technologyServicePort;
    private final ITechnologyRequestMapper technologyRequestMapper;
    private final ITechnologyResponseMapper technologyResponseMapper;

    public TechnologyHandler(ITechnologyServicePort technologyServicePort, ITechnologyRequestMapper technologyRequestMapper, ITechnologyResponseMapper technologyResponseMapper) {
        this.technologyServicePort = technologyServicePort;
        this.technologyRequestMapper = technologyRequestMapper;
        this.technologyResponseMapper = technologyResponseMapper;
    }


    @Override
    public Mono<TechnologyResponseDTO> createTechnology(TechnologyRequestDTO technologyRequestDTO) {
        return technologyServicePort.save(technologyRequestMapper.toTechnology(technologyRequestDTO))
                .map(technologyResponseMapper::toResponse);
    }

    @Override
    public Flux<TechnologyResponseDTO> getTechnologies(int page, int size, boolean asc) {
        return technologyServicePort.findAll(page, size, asc)
                .map(technologyResponseMapper::toResponse);
    }

    @Override
    public Mono<TechnologyResponseDTO> getTechnology(Long technologyId) {
        return technologyServicePort.findById(technologyId)
                .map(technologyResponseMapper::toResponse);
    }
}
