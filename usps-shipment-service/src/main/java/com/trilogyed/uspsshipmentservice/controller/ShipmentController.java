package com.trilogyed.uspsshipmentservice.controller;

import com.trilogyed.uspsshipmentservice.dao.ShipmentDao;
import com.trilogyed.uspsshipmentservice.model.Shipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RefreshScope
public class ShipmentController {

    @Autowired
    ShipmentDao shipmentDao;

   @GetMapping("shipment/{trackingNumber}")
   public Shipment getShipment(String trackingNumber){
       Shipment shipment=shipmentDao.getShipment(trackingNumber);
       if(shipment==null)
           throw new NoSuchElementException("Shipment does not exist!");
       return shipment;
   }


    @RequestMapping(value = "/shipment/addshipment", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Shipment addShipment(@RequestBody Shipment shipment) {

        Shipment exists = shipmentDao.getShipment(shipment.getTrackingNumber());
        if (exists != null)
            throw new IllegalArgumentException("Shipment " + shipment.getId() + " already exists.");
        shipmentDao.createShipment(shipment);
        return shipment;    }
    {

   }


}
