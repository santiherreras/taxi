package com.solvd.taxi.model;
public class Review {
    private final Ride ride;
    private final float rating; // 1 to 5
    private final String comment;

    public Review(Ride ride, float rating, String comment) {
        this.ride = ride;
        this.rating = rating;
        this.comment = comment;
    }

    public Ride getRide() {
        return ride;
    }

    public float getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }
}
