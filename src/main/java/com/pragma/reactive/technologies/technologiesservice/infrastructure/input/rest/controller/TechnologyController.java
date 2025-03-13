package com.pragma.reactive.technologies.technologiesservice.infrastructure.input.rest.controller;

import com.pragma.reactive.technologies.technologiesservice.application.handler.ITechnologyHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/technology")
@RequiredArgsConstructor
public class TechnologyController {

    private final ITechnologyHandler technologyHandler;

}
