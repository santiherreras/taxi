package com.solvd.taxi.model;
import java.time.LocalDate;
import java.util.Objects;

public class Driver extends User implements Locatable, Verifiable {
    private LocalDate birthDay;
    private int weight;
    private int height;
    private boolean hasLicense;
    private boolean hasCriminalRecord;
    private boolean available;
    private Vehicle vehicle;
    private Location currentLocation;
    private TaxiCompany company;

    public Driver(String name, String id, LocalDate birthDay, int weight, int height, boolean hasLicense, boolean available, Vehicle vehicle, Location currentLocation, boolean hasCriminalRecord) {
        super(name, id);
        this.birthDay = birthDay;
        this.weight = weight;
        this.height = height;
        this.hasLicense = hasLicense;
        this.available = available;
        this.vehicle = vehicle;
        this.currentLocation = currentLocation;
        this.hasCriminalRecord = hasCriminalRecord;
        this.company = null;
    }


    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean hasLicense() {
        return hasLicense;
    }

    public void setHasLicense(boolean hasLicense) {
        this.hasLicense = hasLicense;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public TaxiCompany getCompany() {
        return company;
    }

    public void setCompany(TaxiCompany company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "birthDay=" + birthDay +
                ", weight=" + weight +
                ", height=" + height +
                ", license=" + hasLicense +
                ", available=" + available +
                ", vehicle=" + vehicle +
                ", currentLocation=" + currentLocation +
                ", company=" + company +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return weight == driver.weight && height == driver.height && hasLicense == driver.hasLicense && available == driver.available && Objects.equals(name, driver.name) && Objects.equals(birthDay, driver.birthDay) && Objects.equals(vehicle, driver.vehicle) && Objects.equals(currentLocation, driver.currentLocation) && Objects.equals(company, driver.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthDay, weight, height, hasLicense, available, vehicle, currentLocation, company);
    }


    @Override
    public boolean verifyBackground() {
        return !hasCriminalRecord && hasLicense;
    }
}
