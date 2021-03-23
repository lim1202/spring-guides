package com.example.demo.common;

public class TokenConstant {

    private TokenConstant() {
        throw new IllegalStateException("Constant class");
    }

    public static final String HEADER_NAME = "Authorization";
    public static final String HEADER_PREFIX = "Bearer ";
    
}
