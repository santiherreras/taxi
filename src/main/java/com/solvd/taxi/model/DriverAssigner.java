package com.solvd.taxi.model;

import java.util.List;

public class DriverAssigner<T extends Driver> {

    public T findClosestAvailableDriver(Location origin, List<T> drivers)
            throws NoAvailableDriverException {

        return drivers.stream()
                .filter(Driver::isAvailable)
                .min((d1, d2) -> Float.compare(
                        Ride.calculateDistance(origin, d1.getCurrentLocation()),
                        Ride.calculateDistance(origin, d2.getCurrentLocation())
                ))
                .orElseThrow(() ->
                        new NoAvailableDriverException("No available drivers near origin: " + origin)
                );
    }
}
