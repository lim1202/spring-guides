package com.example.demo.common;

enum ResultEnum {
    SUCCESS(200, "Success"),
    FAILED(500, "Fail");

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
