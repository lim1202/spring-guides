package com.example.demo.config;

import com.example.demo.common.ResultEntity;
import com.example.demo.common.ResultEnum;
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
            log.error("⛔️ {}", businessException.getResultMessage());
            return ResponseEntity.ok(ResultEntity.error(businessException.getCode(), businessException.getMessage(), businessException.getDescription()));
        } else if (e instanceof ForbiddenException) {
            ForbiddenException forbiddenException = (ForbiddenException) e;
            log.error("⛔️ {}", forbiddenException.getResultMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ResultEntity.error(forbiddenException.getCode(), forbiddenException.getMessage(), forbiddenException.getDescription()));
		} else {
            log.error("⛔️ {}:{}", ResultEnum.FAILED.getCode(), ResultEnum.FAILED.getMessage(), e);
			return ResponseEntity.ok(ResultEntity.error(e.toString()));
		}
    }
    
}
