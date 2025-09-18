package com.solvd.taxi.model;

public class OverCapacityException extends Exception {
    public OverCapacityException(String message) {
        super(message);
    }
}
