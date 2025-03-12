package com.pragma.reactive.technologies.technologiesservice.application.handler;

import com.pragma.reactive.technologies.technologiesservice.application.dto.request.TechnologyRequestDTO;
import com.pragma.reactive.technologies.technologiesservice.application.dto.response.TechnologyResponseDTO;
import com.pragma.reactive.technologies.technologiesservice.application.mapper.ITechnologyRequestMapper;
import com.pragma.reactive.technologies.technologiesservice.application.mapper.ITechnologyResponseMapper;
import com.pragma.reactive.technologies.technologiesservice.domine.api.ITechnologyServicePort;
import com.pragma.reactive.technologies.technologiesservice.domine.model.Technology;

import java.util.List;

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
    public TechnologyResponseDTO createTechnology(TechnologyRequestDTO technologyRequestDTO) {
        return technologyResponseMapper.toResponse(technologyServicePort.save(technologyRequestMapper.toTechnology(TechnologyRequestDTO)));
    }

    @Override
    public List<TechnologyResponseDTO> getTechnologies() {
        return technologyResponseMapper.toResponseList(technologyServicePort.findAll());
    }

    @Override
    public TechnologyResponseDTO getTechnology(Long technologyId) {
        return technologyResponseMapper.toResponse(technologyServicePort.findById(technologyId));
    }
}
