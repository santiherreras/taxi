package com.solvd.taxi.model;
public class Motorcycle extends Vehicle{
    public Motorcycle(String brand, String color, int year, int capacity, int avgSpeed){
        super(brand,color,year,capacity,avgSpeed);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.MOTORCYCLE;
    }

}
