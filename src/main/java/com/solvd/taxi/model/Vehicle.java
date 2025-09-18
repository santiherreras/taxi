package com.solvd.taxi.model;
import java.util.Objects;

public abstract class Vehicle {
    protected String brand;
    protected String color;
    protected int year;
    protected int capacity;
    protected int avgSpeed;//units per hour

    public Vehicle(String brand, String color, int year, int capacity, int avgSpeed) {
        this.brand = brand;
        this.color = color;
        this.year = year;
        this.capacity = capacity;
        this.avgSpeed = avgSpeed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAvgSpeed() {
        return avgSpeed;
    }

    public void setAvgSpeed(int avgSpeed) {
        this.avgSpeed = avgSpeed;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", year=" + year +
                ", avgSpeed=" + avgSpeed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return year == vehicle.year && avgSpeed == vehicle.avgSpeed && Objects.equals(brand, vehicle.brand) && Objects.equals(color, vehicle.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, color, year, avgSpeed);
    }

    //Polymorphism
    public abstract VehicleType getType();

}
