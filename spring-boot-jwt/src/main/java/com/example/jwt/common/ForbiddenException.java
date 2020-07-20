package com.example.jwt.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Unauthorized")
public class ForbiddenException extends RuntimeException {
    private static final long serialVersionUID = 1L;
}