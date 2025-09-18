package com.solvd.taxi.model;
public abstract class TransportService {
    protected String serviceId;
    protected String description;

    public TransportService(String serviceId, String description) {
        this.serviceId = serviceId;
        this.description = description;
    }

    public String getServiceId() {
        return serviceId;
    }

    public String getDescription() {
        return description;
    }

    public abstract void calculateServiceDetails();


}
