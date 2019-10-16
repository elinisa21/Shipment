package com.trilogyed.clientservice.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Shipment {

    private int id;
    private String name;
    private String trackingNumber;

    public Shipment(int id, String name, String trackingNumber) {
        this.id = id;
        this.name = name;
        this.trackingNumber = trackingNumber;
    }
    public Shipment(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shipment shipment = (Shipment) o;
        return id == shipment.id &&
                Objects.equals(name, shipment.name) &&
                Objects.equals(trackingNumber, shipment.trackingNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, trackingNumber);
    }
}