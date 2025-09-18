package com.solvd.taxi.model;

public class InvalidPaymentMethodException extends Exception {
    public InvalidPaymentMethodException(String message) {
        super(message);
    }
}
