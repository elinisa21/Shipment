package com.trilogyed.clientservice.service;

import com.trilogyed.clientservice.model.Shipment;
import com.trilogyed.clientservice.util.feign.ShipmentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceLayer {

        private ShipmentClient client;

      @Autowired
      public ServiceLayer(ShipmentClient client) {

            this.client = client;

        }


        public Shipment add(Shipment consumer) {

            return client.addShipment(consumer);

        }



        public Shipment get(String trackingNumber) {

            return client.getShipment(trackingNumber);

        }
}




