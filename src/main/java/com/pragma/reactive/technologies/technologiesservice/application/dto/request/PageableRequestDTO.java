package com.pragma.reactive.technologies.technologiesservice.application.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageableRequestDTO {
    @NotEmpty(message = "page cannot be null")
    private int page;
    @NotEmpty(message = "size cannot be null")
    private int size;
    @NotEmpty(message = "asc cannot be null")
    private boolean asc;
}
