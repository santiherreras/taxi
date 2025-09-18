package com.solvd.taxi.model;
@FunctionalInterface
public interface RideSummaryFormatter {
    String format(Ride ride, double fare, double discountedFare, PaymentMethod method);
}
