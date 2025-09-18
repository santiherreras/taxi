package com.solvd.taxi.model;
@FunctionalInterface
public interface FareModifier {
    double apply(double fare);
}