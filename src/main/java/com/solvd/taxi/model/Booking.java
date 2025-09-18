package com.solvd.taxi.model;

import java.time.LocalDateTime;

public class Booking<T extends TransportService> {
    private T ride;
    private LocalDateTime bookingTime;
    private BookingStatus status; // pending, confirmed, cancelled

    public Booking(LocalDateTime bookingTime, T ride) {
        this.bookingTime = bookingTime;
        this.ride = ride;
        this.status = BookingStatus.PENDING;
    }

    public void confirm() {
        this.status = BookingStatus.CONFIRMED;
    }

    public void cancel() {
        this.status = BookingStatus.CANCELLED;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public LocalDateTime getBookingTime(){
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public T getRide() {
        return ride;
    }

    public void setRide(T ride) {
        this.ride = ride;
    }
}
