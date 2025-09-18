package com.solvd.taxi.model;

public class InvalidLocationException extends Exception {
    public InvalidLocationException(String message) {
        super(message);
    }
}
