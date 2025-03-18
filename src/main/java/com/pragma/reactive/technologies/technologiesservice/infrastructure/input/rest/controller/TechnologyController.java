package com.pragma.reactive.technologies.technologiesservice.infrastructure.input.rest.controller;

import com.pragma.reactive.technologies.technologiesservice.application.dto.request.TechnologyRequestDTO;
import com.pragma.reactive.technologies.technologiesservice.application.dto.response.TechnologyResponseDTO;
import com.pragma.reactive.technologies.technologiesservice.application.handler.ITechnologyHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/technology")
@RequiredArgsConstructor
@Tag(name = "Technologies", description = "Gestion Technology")
public class TechnologyController {
    private final ITechnologyHandler technologyHandler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create Technologies", description = "this endpoint save technology")
    public Mono<TechnologyResponseDTO> saveTechnology(@Valid @RequestBody TechnologyRequestDTO technologyRequestDTO) {
        return technologyHandler.createTechnology(technologyRequestDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all technologies", description = "this endpoint return a list technologies")
    public Flux<TechnologyResponseDTO> getAllTechnologies(@RequestParam(defaultValue = "0") int page,
                                                          @RequestParam(defaultValue = "10") int size,
                                                          @RequestParam(defaultValue = "true") boolean asc) {
        return technologyHandler.getTechnologies(page, size, asc);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get technology by id", description = "this endpoint return technology")
    public Mono<TechnologyResponseDTO> getTechnology(@PathVariable Long id) {
        return technologyHandler.getTechnology(id);
    }

}
