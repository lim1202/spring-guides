package com.example.demo.exception;

import com.example.demo.common.ResultEnum;

public class BusinessException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    private final ResultEnum result;

    public BusinessException() {
        this.result = ResultEnum.FAILED;
    }

    public BusinessException(ResultEnum result) {
        this.result = result;
    }

    public BusinessException(ResultEnum result, String message) {
        super(message);
        this.result = result;
    }

    public ResultEnum getResult() {
        return result;
    }
    
}
