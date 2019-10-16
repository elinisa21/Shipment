package com.trilogyed.clientservice.util.feign;

import com.trilogyed.clientservice.model.Shipment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "usps-shipment-service")
public interface ShipmentClient {

    @RequestMapping(value = "/shipment/addshipment", method = RequestMethod.POST)
    Shipment addShipment(@RequestBody Shipment shipment);

    @RequestMapping(value = "/shipment/{trackingnumber}", method = RequestMethod.GET)
    Shipment getShipment(@PathVariable String trackingNumber);

}
