package com.pragma.reactive.technologies.technologiesservice.application.mapper;

import com.pragma.reactive.technologies.technologiesservice.application.dto.request.TechnologyRequestDTO;
import com.pragma.reactive.technologies.technologiesservice.domine.model.Technology;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import reactor.core.publisher.Mono;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ITechnologyRequestMapper {
    Mono<Technology> toTechnologyMono(TechnologyRequestDTO technologyRequestDTO);
    Technology toTechnology(TechnologyRequestDTO technologyRequestDTO);
}
