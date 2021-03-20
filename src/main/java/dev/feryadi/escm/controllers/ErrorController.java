package dev.feryadi.escm.controllers;

import dev.feryadi.escm.exceptions.NotFoundException;
import dev.feryadi.escm.models.ApiResponse;
import dev.feryadi.escm.models.ApiResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class ErrorController {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiResponse> notFound(NotFoundException notFoundException) {
        ApiResponseError<Object> apiResponse = new ApiResponseError<>("NOT FOUND", 404, notFoundException.getMessage());
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiResponse> constraintViolation(
            ConstraintViolationException constraintViolationException) {
        ApiResponseError<Object> apiResponse = new ApiResponseError<>("UNPROCESSABLE ENTITY", 422, constraintViolationException.getMessage());
        return new ResponseEntity<>(apiResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
