package com.solvd.taxi.model;
@FunctionalInterface
public interface DriverFilter {
    boolean test(Driver driver);
}