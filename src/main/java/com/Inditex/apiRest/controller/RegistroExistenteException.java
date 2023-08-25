package com.Inditex.apiRest.controller;

public class RegistroExistenteException extends Throwable {
    public RegistroExistenteException(String message) {
        super(message);
    }

    public RegistroExistenteException(String message, Throwable cause) {
        super(message, cause);
    }
}
