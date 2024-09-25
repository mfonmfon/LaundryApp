package com.semicolon.africa.laundryluxe.exceptions;

public class PasswordNotExistException extends RuntimeException {
    public PasswordNotExistException(String message) {
        super(message);
    }
}
