package com.solvd.taxi.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CryptoPayment extends Payment {
    private static final Logger LOGGER = LogManager.getLogger(CryptoPayment.class);
    private final String walletAddress;
    private final String cryptoType; // BTC, ETH

    public CryptoPayment(double amount, String walletAddress, String cryptoType) {
        super(amount);
        this.walletAddress = walletAddress;
        this.cryptoType = cryptoType;
    }

    @Override
    public boolean processPayment() {
        LOGGER.info("Sending {} in {} to wallet address {}", amount, cryptoType, walletAddress);
        this.confirmed = true;
        return true;
    }
}
