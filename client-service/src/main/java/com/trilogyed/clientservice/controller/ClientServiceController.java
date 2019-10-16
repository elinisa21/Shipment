package com.trilogyed.clientservice.controller;

import com.trilogyed.clientservice.model.Shipment;
import com.trilogyed.clientservice.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public Shipment addShipment(@RequestBody @Valid Shipment svm){

        svm = sl.add(svm);

        return svm;
    }

    @RequestMapping(value="/clientfe/shipment/{trackingnumber}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Shipment getShipment(@PathVariable @Valid String trackingNumber){
        if (trackingNumber == null){
            throw new NumberFormatException("Please enter valid tracking number.");
        }
        return sl.get(trackingNumber);
    }


}

