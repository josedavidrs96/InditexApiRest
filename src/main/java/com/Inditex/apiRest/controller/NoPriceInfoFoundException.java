package com.Inditex.apiRest.controller;

public class NoPriceInfoFoundException extends RuntimeException {

    public NoPriceInfoFoundException(String message) {
        super(message);
    }

    public NoPriceInfoFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

