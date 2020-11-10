package com.example.demo.config;

import com.example.demo.common.ResultEntity;
import com.example.demo.exception.BusinessException;
import com.example.demo.exception.ForbiddenException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ResultEntity<?>> handleException(Exception e) {
        if (e instanceof BusinessException) {
            BusinessException businessException = (BusinessException) e;
            log.error(String.format("⛔️ %s:%s", businessException.getResult().getCode(), businessException.getResult().getMessage()), e);
            return ResponseEntity.ok(ResultEntity.error(businessException.getMessage(), businessException.getResult()));
        } else if (e instanceof ForbiddenException) {
            ForbiddenException forbiddenException = (ForbiddenException) e;
            log.error(String.format("⛔️ %s:%s", forbiddenException.getResult().getCode(), forbiddenException.getResult().getMessage()), e);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ResultEntity.error(forbiddenException.getMessage(), forbiddenException.getResult()));
		} else {
            log.error("⛔️", e);
			return ResponseEntity.ok(ResultEntity.error());
		}
    }
    
}
