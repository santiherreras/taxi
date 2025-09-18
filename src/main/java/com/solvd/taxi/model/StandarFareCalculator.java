package com.solvd.taxi.model;

import java.text.DecimalFormat;

public class StandarFareCalculator extends FareCalculator {

    public StandarFareCalculator(double baseFare, double perUnitFare) {
        super(baseFare, perUnitFare);
    }

    @Override
    public double calculateFare(Ride ride) throws FareCalculatorException {
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        if (ride.getDistance() <= 0 || this.baseFare <= 0|| this.perunitFare <= 0) {
            throw new FareCalculatorException("Distance and fare invalid.");
        } else
            return Double.parseDouble(numberFormat.format(baseFare + (ride.getDistance() * super.getPerunitFare())));
    }
}
