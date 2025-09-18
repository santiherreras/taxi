package com.solvd.taxi.model;
@FunctionalInterface
public interface CalculableFare {
    double calculateFare(Ride ride) throws FareCalculatorException;
}
