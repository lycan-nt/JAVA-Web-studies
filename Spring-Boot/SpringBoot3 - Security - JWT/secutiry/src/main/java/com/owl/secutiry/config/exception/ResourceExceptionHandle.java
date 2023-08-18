package com.owl.secutiry.config.exception;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.ServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ResourceExceptionHandle {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardError> exceptionsError(Exception e, ServletRequest servletRequest) {
        StandardError standardError = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<StandardError> expiredError(ExpiredJwtException e, ServletRequest servletRequest) {
        StandardError standardError = new StandardError(System.currentTimeMillis(), HttpStatus.UNAUTHORIZED.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(standardError);
    }

}
