package com.semicolon.africa.laundryluxe.exceptions;

public class UnMatchablePassword extends RuntimeException {
    public UnMatchablePassword(String message) {
        super(message);
    }
}
