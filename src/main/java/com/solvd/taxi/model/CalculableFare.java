package com.solvd.taxi.model;
public interface CalculableFare {
    double calculateFare(Ride ride) throws FareCalculatorException;
}
