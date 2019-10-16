package com.trilogyed.clientservice.service;

import com.trilogyed.clientservice.model.Shipment;
import com.trilogyed.clientservice.model.ShipmentViewModel;
import com.trilogyed.clientservice.util.feign.ShipmentClient;
import org.junit.Before;
import org.junit.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ServiceLayerTest {

    ShipmentClient client;
    ServiceLayer serviceLayer;

    @Before
    public void setUp() throws Exception {
        setUpShipmentMock();
        serviceLayer = new ServiceLayer(client);
    }

    @Test
    public void saveFindShipment() {
        Shipment shipment = new Shipment();
        shipment.setName("The Alchemist");
        shipment.setTrackingNumber("200000a");

        ShipmentViewModel shipmentViewModel = serviceLayer.addShipment(shipment);
        ShipmentViewModel fromService = serviceLayer.getShipment(shipmentViewModel.getTrackingNumber());
        assertEquals(fromService, shipmentViewModel);

        ShipmentViewModel shipmentViewModel1 = serviceLayer.getShipment("200000a");
        assertEquals(2, shipmentViewModel1.getTrackingNumber());
    }


    private void setUpShipmentMock() {
        client = mock(ShipmentClient.class);

        Shipment shipment = new Shipment();
        shipment.setId(1);
        shipment.setName("Morpheus");
        shipment.setTrackingNumber("123ab");

        Shipment shipment1 = new Shipment();
        shipment1.setId(1);
        shipment1.setName("Morpheus");
        shipment1.setTrackingNumber("123ab");

        Shipment shipment2 = new Shipment();
        shipment2.setId(1);
        shipment2.setName("Morpheus");
        shipment2.setTrackingNumber("123ab");



        doReturn(shipment).when(client).getShipment("123ab");

    }



}
