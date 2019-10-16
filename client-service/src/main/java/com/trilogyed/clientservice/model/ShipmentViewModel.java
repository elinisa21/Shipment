package com.trilogyed.clientservice.model;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ShipmentViewModel {

    private int id;
    private String name;
    private String trackingNumber;

    public ShipmentViewModel(int id, String name, String trackingNumber) {
        this.id = id;
        this.name = name;
        this.trackingNumber = trackingNumber;
    }

    public ShipmentViewModel(){

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
        ShipmentViewModel that = (ShipmentViewModel) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(trackingNumber, that.trackingNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, trackingNumber);
    }
}