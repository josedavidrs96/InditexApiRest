package com.Inditex.apiRest.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Getter
@Setter
public class CustomErrorResponse extends ResponseEntityExceptionHandler {

    private String message;
    public CustomErrorResponse(String message) {
        this.message = message;
    }
}
