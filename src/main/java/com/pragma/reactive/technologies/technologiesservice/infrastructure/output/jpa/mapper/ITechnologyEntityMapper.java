package com.pragma.reactive.technologies.technologiesservice.infrastructure.output.jpa.mapper;

import com.pragma.reactive.technologies.technologiesservice.domine.model.Technology;
import com.pragma.reactive.technologies.technologiesservice.infrastructure.output.jpa.entity.TechnologyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.context.annotation.Primary;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Primary
public interface ITechnologyEntityMapper {
    TechnologyEntity toTechnologyEntity(Technology technology);
    Technology toTechnologyModel(TechnologyEntity technologyEntity);
}
