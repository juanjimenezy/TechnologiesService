package com.pragma.reactive.technologies.technologiesservice.application.handler;

import com.pragma.reactive.technologies.technologiesservice.application.dto.request.TechnologyRequestDTO;
import com.pragma.reactive.technologies.technologiesservice.application.dto.response.TechnologyResponseDTO;
import com.pragma.reactive.technologies.technologiesservice.domine.model.Technology;

import java.util.List;

public interface ITechnologyHandler {
    TechnologyResponseDTO createTechnology(TechnologyRequestDTO technologyRequestDTO);
    List<TechnologyResponseDTO> getTechnologies();
    TechnologyResponseDTO getTechnology(Long technologyId);
}
