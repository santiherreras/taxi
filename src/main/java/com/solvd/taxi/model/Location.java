package com.solvd.taxi.model;

public class Location {
    private float latitude;
    private float longitude;

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public Location(float latitude, float longitude) throws InvalidLocationException {
        if (latitude < -90 || latitude > 90) {
            throw new InvalidLocationException("Invalid latitude: " + latitude + ". Must be between -90 and 90.");
        }
        if (longitude < -180 || longitude > 180) {
            throw new InvalidLocationException("Invalid longitude: " + longitude + ". Must be between -180 and 180.");
        }
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Location{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
