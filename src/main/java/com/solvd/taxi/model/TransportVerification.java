package com.solvd.taxi.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TransportVerification {
    private static final Logger LOGGER = LogManager.getLogger(TransportVerification.class);

    public void runVerification(Verifiable person) throws VerificationFailedException {
        boolean verified = person.verifyBackground();

        if (verified) {
            LOGGER.info("Background check passed.");
        } else {
            LOGGER.error("Background check failed.");
            throw new VerificationFailedException("Driver verification failed due to invalid license or criminal record.");
        }
    }
}
