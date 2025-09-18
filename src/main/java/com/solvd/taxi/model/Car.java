package com.solvd.taxi.model;
public class Car extends Vehicle {
    public Car(String brand, String color, int year, int capacity, int avgSpeed) {
        super(brand, color, year, capacity, avgSpeed);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.CAR;
    }
}
