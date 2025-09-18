package com.solvd.taxi.model;
import java.util.Objects;

public class Passenger extends User{

    private PaymentMethod paymentMethod;
    private char gender;

    public Passenger(String name, String id, PaymentMethod paymentMethod) {
       super(name,id);
        this.paymentMethod = paymentMethod;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", gender=" + gender +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return gender == passenger.gender && Objects.equals(name, passenger.name) && Objects.equals(id, passenger.id) && Objects.equals(paymentMethod, passenger.paymentMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, paymentMethod, gender);
    }

}
