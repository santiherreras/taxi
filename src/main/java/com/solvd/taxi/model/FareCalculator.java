package com.solvd.taxi.model;
public abstract class FareCalculator implements CalculableFare {
    protected double baseFare ;
    protected double perunitFare;

    public FareCalculator(double baseFare, double perunitFare) {
        this.baseFare = baseFare;
        this.perunitFare = perunitFare;
    }

    public abstract double calculateFare(Ride ride) throws FareCalculatorException;

    public double getBaseFare() {
        return baseFare;
    }

    public void setBaseFare(double baseFare) {
        this.baseFare = baseFare;
    }

    public double getPerunitFare() {
        return perunitFare;
    }

    public void setPerunitFare(double perunitFare) {
        this.perunitFare = perunitFare;
    }
}
