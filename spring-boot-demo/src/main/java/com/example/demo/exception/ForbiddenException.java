package com.example.demo.exception;

import com.example.demo.common.ResultEnum;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class ForbiddenException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String code;
    private final String description;

    public ForbiddenException() {
        super(ResultEnum.A0301.getMessage());
        this.code = ResultEnum.A0301.getCode();
        this.description = "";
    }

    public ForbiddenException(String description) {
        super(ResultEnum.A0301.getMessage());
        this.code = ResultEnum.A0301.getCode();
        this.description = description;
    }

    public ForbiddenException(ResultEnum result) {
        super(ResultEnum.A0301.getMessage());
        this.code = ResultEnum.A0301.getCode();
        this.description = "";
    }

    public ForbiddenException(ResultEnum result, String description) {
        super(result.getMessage());
        this.code = result.getCode();
        this.description = description;
    }

    public String getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

    public String getResultMessage() {
        return String.format("%s:%s - %s", this.code, this.getMessage(), description);
    }
    
}