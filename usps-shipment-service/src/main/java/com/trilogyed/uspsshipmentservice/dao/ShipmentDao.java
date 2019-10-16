package com.trilogyed.uspsshipmentservice.dao;

import com.trilogyed.uspsshipmentservice.model.Shipment;

public interface ShipmentDao {

    Shipment createShipment(Shipment shipment);
    Shipment getShipment(String trackingNumber);

}
