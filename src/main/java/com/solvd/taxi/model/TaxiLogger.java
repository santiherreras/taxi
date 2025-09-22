package com.solvd.taxi.model;
import java.util.logging.Logger;

public enum TaxiLogger {
    INSTANCE;

    private static final Logger LOGGER = Logger.getLogger(TaxiLogger.class.getName());

    public void log(String message) {
        LOGGER.info(Thread.currentThread().getName() + message);
    }
}

