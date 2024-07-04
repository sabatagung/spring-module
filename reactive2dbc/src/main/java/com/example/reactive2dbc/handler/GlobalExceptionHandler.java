package com.example.reactive2dbc.handler;

import com.example.reactive2dbc.ErrorResponse.ErrorResponse;
import com.example.reactive2dbc.exception.BookNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;
import reactor.core.publisher.Mono;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Mono<ErrorResponse> handleBookNotFoundException(BookNotFoundException ex){
        return Mono.just(new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage()));
    }
}