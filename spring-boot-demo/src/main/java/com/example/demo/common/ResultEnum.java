package com.example.demo.common;

enum ResultEnum {
    SUCCESS(200, "success"),
    FAILED(500, "failed");

    private final int code;
    private final String message;

    private ResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
