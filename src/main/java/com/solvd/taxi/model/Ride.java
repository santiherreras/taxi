package com.solvd.taxi.model;
import java.util.Objects;

public class Ride extends TransportService {
    private Location origin;
    private Location destination;
    private float distance;
    private int duration;
    private Passenger passenger;
    private Driver driver;
    private int waitingTime;
    private int passengersCount;

    public Ride(Passenger passenger, Driver driver, Location origin, Location destination, String serviceId, String description, int passengersCount) throws  OverCapacityException{
        super(serviceId,description);
        if(passengersCount > driver.getVehicle().getCapacity()){
            throw new OverCapacityException("Passengers exceeds vehicle capacity");
        }
        this.passenger = passenger;
        this.driver = driver;
        this.destination = destination;
        this.origin = origin;
        this.passengersCount = passengersCount;
        calculateServiceDetails();
    }

    public Location getOrigin() {
        return origin;
    }

    public void setOrigin(Location origin) {
        this.origin = origin;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public float getDistance() {
        return distance;
    }

    public int getDuration() {
        return duration;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public int getPassengersCount() {
        return passengersCount;
    }

    public void setPassengersCount(int passengersCount) {
        this.passengersCount = passengersCount;
    }

    public static float calculateDistance(Location pointA, Location pointB) {
        float xDiff = pointA.getLatitude() - pointB.getLatitude();
        float yDiff = pointA.getLongitude() - pointB.getLongitude();
        return (float) Math.sqrt((xDiff * xDiff) + (yDiff * yDiff));
    }

    @Override
    public void calculateServiceDetails() {
        float distanceToPassenger = calculateDistance(driver.getCurrentLocation(), origin);
        this.waitingTime = (int) ((distanceToPassenger / driver.getVehicle().getAvgSpeed()) * 60);

        this.distance = calculateDistance(origin, destination);
        this.duration = (int) ((distance / driver.getVehicle().getAvgSpeed()) * 60);
    }

    @Override
    public String toString() {
        return "Ride{" +
                "origin=" + origin.toString() +
                ", destination=" + destination.toString() +
                ", distance=" + distance +
                ", duration=" + duration +
                ", passenger=" + passenger +
                ", driver=" + driver +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ride ride = (Ride) o;
        return Float.compare(distance, ride.distance) == 0 && duration == ride.duration && waitingTime == ride.waitingTime && Objects.equals(origin, ride.origin) && Objects.equals(destination, ride.destination) && Objects.equals(passenger, ride.passenger) && Objects.equals(driver, ride.driver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(origin, destination, distance, duration, passenger, driver, waitingTime);
    }
}
