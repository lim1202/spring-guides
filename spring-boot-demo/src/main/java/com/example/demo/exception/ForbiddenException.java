package com.example.demo.exception;

import com.example.demo.common.ResultEnum;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class ForbiddenException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final ResultEnum result;

    public ForbiddenException() {
        this.result = ResultEnum.A0311;
    }

    public ForbiddenException(ResultEnum result) {
        this.result = result;
    }

    public ForbiddenException(ResultEnum result, String message) {
        super(message);
        this.result = result;
    }

    public ResultEnum getResult() {
        return result;
    }

    public String getResultMessage() {
        return String.format("%s:%s - %s", result.getCode(), result.getMessage(), super.getMessage());
    }
    
}