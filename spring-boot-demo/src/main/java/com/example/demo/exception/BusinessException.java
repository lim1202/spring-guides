package com.example.demo.exception;

import com.example.demo.common.ResultEnum;

public class BusinessException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    private final String code;
    private final String description;

    public BusinessException() {
        super(ResultEnum.FAILED.getMessage());
        this.code = ResultEnum.FAILED.getCode();
        this.description = "";
    }

    public BusinessException(String description) {
        super(ResultEnum.FAILED.getMessage());
        this.code = ResultEnum.FAILED.getCode();
        this.description = description;
    }

    public BusinessException(ResultEnum result) {
        super(result.getMessage());
        this.code = result.getCode();
        this.description = "";
    }

    public BusinessException(ResultEnum result, String description) {
        super(result.getMessage());
        this.code = result.getCode();
        this.description = description;
    }

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
        this.description = "";
    }

    public BusinessException(String code, String message, String description) {
        super(message);
        this.code = code;
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