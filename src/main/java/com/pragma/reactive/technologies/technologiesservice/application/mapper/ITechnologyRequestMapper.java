package com.pragma.reactive.technologies.technologiesservice.application.mapper;

import com.pragma.reactive.technologies.technologiesservice.application.dto.request.TechnologyRequestDTO;
import com.pragma.reactive.technologies.technologiesservice.domine.model.Technology;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ITechnologyRequestMapper {
    Technology toTechnologyMono(TechnologyRequestDTO technologyRequestDTO);
    Technology toTechnology(TechnologyRequestDTO technologyRequestDTO);
}
