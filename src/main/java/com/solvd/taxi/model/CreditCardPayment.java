package com.solvd.taxi.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CreditCardPayment extends Payment {
    private static final Logger LOGGER = LogManager.getLogger(CreditCardPayment.class);
    @SensitiveData
    private String cardNumber;
    private String owner;

    public CreditCardPayment(double amount) {
        super(amount);
    }

    public CreditCardPayment(String owner, String cardNumber, double amount) {
        super(amount);
        this.owner = owner;
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean processPayment() {
        LOGGER.info("Processing credit card payment of ${}", amount);
        this.confirmed = true;
        return true;
    }


}
