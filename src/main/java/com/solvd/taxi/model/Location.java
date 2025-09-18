package com.solvd.taxi.model;

public class Location {
    private float latitude;
    private float longitude;

    public Location(float latitude, float longitude) throws InvalidLocationException {
        validateCoordinates(latitude, longitude);
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) throws InvalidLocationException {
        validateCoordinates(latitude, this.longitude);
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) throws InvalidLocationException {
        validateCoordinates(this.latitude, longitude);
        this.longitude = longitude;
    }

    private void validateCoordinates(float latitude, float longitude) throws InvalidLocationException {
        if (latitude < -90 || latitude > 90) {
            throw new InvalidLocationException("Invalid latitude: " + latitude + ". Must be between -90 and 90.");
        }
        if (longitude < -180 || longitude > 180) {
            throw new InvalidLocationException("Invalid longitude: " + longitude + ". Must be between -180 and 180.");
        }
    }

    @Override
    public String toString() {
        return "Location{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
