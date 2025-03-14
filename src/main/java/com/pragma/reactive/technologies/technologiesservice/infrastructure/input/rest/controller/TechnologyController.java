package com.pragma.reactive.technologies.technologiesservice.infrastructure.input.rest.controller;

import com.pragma.reactive.technologies.technologiesservice.application.dto.request.PageableRequestDTO;
import com.pragma.reactive.technologies.technologiesservice.application.dto.request.TechnologyRequestDTO;
import com.pragma.reactive.technologies.technologiesservice.application.dto.response.TechnologyResponseDTO;
import com.pragma.reactive.technologies.technologiesservice.application.handler.ITechnologyHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/technology")
@RequiredArgsConstructor
public class TechnologyController {


    private final ITechnologyHandler technologyHandler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<TechnologyResponseDTO> saveTechnology(@Valid @RequestBody TechnologyRequestDTO technologyRequestDTO) {
        return technologyHandler.createTechnology(technologyRequestDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<TechnologyResponseDTO> getAllTechnologies(@RequestBody PageableRequestDTO pagueable) {
        return technologyHandler.getTechnologies(pagueable.getPage(), pagueable.getSize(), pagueable.isAsc());
    }

}
