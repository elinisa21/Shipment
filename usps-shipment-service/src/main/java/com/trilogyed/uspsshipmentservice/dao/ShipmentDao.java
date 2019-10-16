package com.trilogyed.uspsshipmentservice.dao;

import com.trilogyed.uspsshipmentservice.model.Shipment;

import java.util.List;

public interface ShipmentDao {

    Shipment createShipment(Shipment shipment);
    Shipment getShipment(String trackingNumber);
    void deleteShipment(int id);
    List<Shipment> getAll();
}

