package com.solvd.taxi.model;
public class Bus extends Vehicle{
    public Bus(String brand, String color, int year, int capacity, int avgSpeed) {
        super(brand, color, year, capacity, avgSpeed);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.BUS;
    }
}
