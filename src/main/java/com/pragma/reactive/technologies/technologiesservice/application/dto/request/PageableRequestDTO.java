package com.pragma.reactive.technologies.technologiesservice.application.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageableRequestDTO {
    private int page;
    private int size;
    private boolean asc;
}
