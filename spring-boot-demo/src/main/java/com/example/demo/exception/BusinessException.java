package com.example.demo.exception;

import com.example.demo.common.ResultEnum;

public class BusinessException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    private final ResultEnum result;
    private final String description;

    public BusinessException() {
        super(ResultEnum.FAILED.getMessage());
        this.result = ResultEnum.FAILED;
        this.description = "";
    }

    public BusinessException(String description) {
        super(ResultEnum.FAILED.getMessage());
        this.result = ResultEnum.FAILED;
        this.description = description;
    }

    public BusinessException(ResultEnum result) {
        super(result.getMessage());
        this.result = result;
        this.description = "";
    }

    public BusinessException(ResultEnum result, String description) {
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
