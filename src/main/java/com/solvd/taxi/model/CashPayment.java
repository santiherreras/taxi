package com.solvd.taxi.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CashPayment extends Payment {
    private static final Logger LOGGER = LogManager.getLogger(CashPayment.class);

    public CashPayment(double amount) {
        super(amount);
    }

    @Override
    public boolean processPayment() {
        LOGGER.info("Processing cash payment of ${}", amount);
        this.confirmed = true;
        return true;
    }
}

