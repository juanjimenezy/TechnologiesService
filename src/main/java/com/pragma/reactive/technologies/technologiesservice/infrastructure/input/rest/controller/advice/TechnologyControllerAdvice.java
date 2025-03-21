package com.pragma.reactive.technologies.technologiesservice.infrastructure.input.rest.controller.advice;

import com.pragma.reactive.technologies.technologiesservice.domain.exception.DomainException;
import com.pragma.reactive.technologies.technologiesservice.infrastructure.input.rest.controller.TechnologyController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice(basePackageClasses = TechnologyController.class)
public class TechnologyControllerAdvice {

    @ExceptionHandler(WebExchangeBindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationExceptions(WebExchangeBindException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );
        return errors;
    }

    @ExceptionHandler(DomainException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleDomainException(DomainException ex) {
        return Map.of("message", ex.getMessage());
    }
}
