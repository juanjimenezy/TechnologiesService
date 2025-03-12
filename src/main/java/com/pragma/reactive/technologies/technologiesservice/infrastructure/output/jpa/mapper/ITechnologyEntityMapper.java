package com.pragma.reactive.technologies.technologiesservice.infrastructure.output.jpa.mapper;

import com.pragma.reactive.technologies.technologiesservice.domine.model.Technology;
import com.pragma.reactive.technologies.technologiesservice.infrastructure.output.jpa.entity.TechnologyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ITechnologyEntityMapper {
    TechnologyEntity toTechnologyEntity(Technology technology);
    Technology toTechnologyModel(TechnologyEntity technologyEntity);
}
