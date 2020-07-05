package com.example.demo.core.resource;

import com.example.demo.resource.dto.ApiErrorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(value = {Throwable.class})
    public ResponseEntity<ApiErrorDto> handUnExpectedException(Exception ex, WebRequest request) {
        LOGGER.error(request.getContextPath(), ex);
        return ResponseEntity.ok(new ApiErrorDto(ex.getMessage()));
    }
}
