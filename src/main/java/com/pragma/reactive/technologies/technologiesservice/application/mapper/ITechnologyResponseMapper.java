package com.pragma.reactive.technologies.technologiesservice.application.mapper;

import com.pragma.reactive.technologies.technologiesservice.application.dto.response.TechnologyResponseDTO;
import com.pragma.reactive.technologies.technologiesservice.domain.model.Technology;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Primary
public interface ITechnologyResponseMapper {
    TechnologyResponseDTO toResponse(Technology technology);
    List<TechnologyResponseDTO> toResponseList(List<Technology> technologies);
}
