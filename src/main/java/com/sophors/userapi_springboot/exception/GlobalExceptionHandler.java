package com.sophors.userapi_springboot.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.HttpRequestMethodNotSupportedException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // ❌ USER NOT FOUND / RUNTIME ERROR
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiError> handleRuntime(RuntimeException ex, HttpServletRequest request) {

        ApiError error = new ApiError(
                "Not Found",
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                request.getRequestURI()
        );

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    };

    // ❌ METHOD NOT ALLOWED (405)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ApiError> handleMethodNotAllowed(
            HttpRequestMethodNotSupportedException ex,
            HttpServletRequest request) {

        ApiError error = new ApiError(
                "Method Not Allowed",
                HttpStatus.METHOD_NOT_ALLOWED.value(),
                "HTTP method not allowed",
                request.getRequestURI()
        );

        return new ResponseEntity<>(error, HttpStatus.METHOD_NOT_ALLOWED);
    };

    // ❌ RESPONSE STATUS EXCEPTION (optional safety)
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ApiError> handleResponseStatus(
            ResponseStatusException ex,
            HttpServletRequest request) {

        ApiError error = new ApiError(
                "Error",
                ex.getStatusCode().value(),
                ex.getReason(),
                request.getRequestURI()
        );

        return new ResponseEntity<>(error, ex.getStatusCode());
    };
}