package com.trilogyed.uspsshipmentservice.model;

import java.util.Objects;

public class Shipment {

    private int id;
    private String name;
    private String trackingNumber;

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
                name.equals(shipment.name) &&
                trackingNumber.equals(shipment.trackingNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, trackingNumber);
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", trackingNumber='" + trackingNumber + '\'' +
                '}';
    }
}
