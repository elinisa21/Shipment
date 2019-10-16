package com.trilogyed.clientservice.service;

import com.trilogyed.clientservice.exception.NotFoundException;
import com.trilogyed.clientservice.model.Shipment;
import com.trilogyed.clientservice.model.ShipmentViewModel;
import com.trilogyed.clientservice.util.feign.ShipmentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceLayer {

    ShipmentClient shipmentService;

    @Autowired
    public ServiceLayer(ShipmentClient shipmentService) {
        this.shipmentService = shipmentService;

    }

    public ShipmentViewModel addShipment(ShipmentViewModel svm) {

        Shipment shipment = new Shipment();
        shipment.setName(svm.getName());
        shipment.setTrackingNumber(svm.getTrackingNumber());


        shipment = shipmentService.addShipment(shipment);
        svm.setId(shipment.getId());


        return buildShipmentViewModel(shipment);
    }



    public ShipmentViewModel getShipment(String trackingNumber) throws NotFoundException {

        Shipment shipment = shipmentService.getShipment(trackingNumber);

        return buildShipmentViewModel(shipment);


    }



    private ShipmentViewModel buildShipmentViewModel(Shipment shipment) {

        ShipmentViewModel svm = new ShipmentViewModel();
        svm.setId(shipment.getId());
        svm.setName(shipment.getName());
        svm.setTrackingNumber(shipment.getTrackingNumber());

        return svm;
    }
}




