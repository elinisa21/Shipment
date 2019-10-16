package com.trilogyed.clientservice.controller;

import com.trilogyed.clientservice.model.ShipmentViewModel;
import com.trilogyed.clientservice.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
public class ClientServiceController {

    @Autowired
    ServiceLayer sl;

    public ClientServiceController(ServiceLayer sl) {
        this.sl = sl;

    }

    @RequestMapping(value="/clientfe/addshipment", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public ShipmentViewModel addShipment(@RequestBody @Valid ShipmentViewModel svm){

        svm = sl.addShipment(svm);

        return svm;
    }

    @RequestMapping(value="/clientfe/shipment/{trackingnumber}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public ShipmentViewModel getShipment(@PathVariable @Valid String trackingNumber){
        if (trackingNumber == null){
            throw new NumberFormatException("Please enter valid tracking number.");
        }
        return sl.getShipment(trackingNumber);
    }


}

