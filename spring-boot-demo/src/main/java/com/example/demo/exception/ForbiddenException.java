package com.example.demo.exception;

import com.example.demo.common.ResultEnum;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class ForbiddenException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final ResultEnum result;
    private final String description;

    public ForbiddenException() {
        super(ResultEnum.A0301.getMessage());
        this.result = ResultEnum.A0301;
        this.description = "";
    }

    public ForbiddenException(String description) {
        super(ResultEnum.A0301.getMessage());
        this.result = ResultEnum.A0301;
        this.description = description;
    }

    public ForbiddenException(ResultEnum result) {
        super(ResultEnum.A0301.getMessage());
        this.result = result;
        this.description = "";
    }

    public ForbiddenException(ResultEnum result, String description) {
        super(result.getMessage());
        this.result = result;
        this.description = description;
    }

    public ResultEnum getResult() {
        return result;
    }

    public String getDescription() {
        return description;
    }

    public String getResultMessage() {
        return String.format("%s:%s - %s", result.getCode(), result.getMessage(), description);
    }
}