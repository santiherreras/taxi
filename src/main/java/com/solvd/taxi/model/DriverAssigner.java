package com.solvd.taxi.model;

import java.util.List;

public class DriverAssigner<T extends Driver> {

    public T findClosestAvailableDriver(Location origin, List<T> drivers)
            throws NoAvailableDriverException {

        T closestDriver = null;
        float minDistance = Float.MAX_VALUE;

        for (T driver : drivers) {
            if (driver.isAvailable()) {
                float distance = Ride.calculateDistance(origin, driver.getCurrentLocation());
                if (distance < minDistance) {
                    minDistance = distance;
                    closestDriver = driver;
                }
            }
        }

        if (closestDriver == null) {
            throw new NoAvailableDriverException("No available drivers near origin: " + origin);
        }

        return closestDriver;
    }
}
