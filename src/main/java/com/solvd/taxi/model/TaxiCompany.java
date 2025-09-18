package com.solvd.taxi.model;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.ArrayList;

public class TaxiCompany{

    private static final Logger LOGGER = LogManager.getLogger(TaxiCompany.class);

    protected String name;
    protected LocalDate foundedDate;
    protected String headquarters;
    private String transportType;
    private ArrayList<Driver> drivers;


    public TaxiCompany(String headquarters, String transportType, LocalDate foundedDate, String name) {
        this.name = name;
        this.foundedDate = foundedDate;
        this.headquarters = headquarters;
        this.transportType = transportType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getFoundedDate() {
        return foundedDate;
    }

    public void setFoundedDate(LocalDate foundedDate) {
        this.foundedDate = foundedDate;
    }

    public String getHeadquarters() {
        return headquarters;
    }

    public void setHeadquarters(String headquarters) {
        this.headquarters = headquarters;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }


    public ArrayList<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(ArrayList<Driver> drivers) {
        this.drivers = drivers;
        for (Driver driver : drivers) {
            driver.setCompany(this);
        }
    }

    public void addDriver(Driver driver) {
        this.drivers.add(driver);
        driver.setCompany(this);
    }

    @Override
    public String toString() {
        return "TaxiCompany{" +
                "name='" + name + '\'' +
                ", foundedDate=" + foundedDate +
                ", transportType='" + transportType + '\'' +
                ", headquarters='" + headquarters + '\'' +
                '}';
    }

    public void verifyCompanyDrivers() {
        for (Driver driver : this.drivers) {
            Verifiable verify = driver;
            if (!verify.verifyBackground()) {
               LOGGER.info("Driver {} failed background check",  driver.getName());
            }
        }
    }

}
