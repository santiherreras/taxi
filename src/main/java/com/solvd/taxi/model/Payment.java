package com.solvd.taxi.model;

public abstract class Payment<T extends Payable> implements Payable {
    protected double amount;
    protected boolean confirmed;

    public Payment(double amount) {
        this.amount = amount;
        this.confirmed = false;
    }

    public void confirmPayment() {
        this.confirmed = true;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public double getAmount() {
        return amount;
    }

    // Cada subclase define su propia lógica
    public abstract boolean processPayment();
}
