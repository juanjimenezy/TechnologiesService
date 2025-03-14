package com.pragma.reactive.technologies.technologiesservice.application.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TechnologyRequestDTO {

    @NotEmpty(message = "name cannot be null")
    private String name;

    @NotEmpty(message = "description cannot be null")
    private String description;
}
