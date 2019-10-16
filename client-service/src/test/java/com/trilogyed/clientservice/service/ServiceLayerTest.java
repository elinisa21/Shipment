package com.trilogyed.clientservice.service;

import com.trilogyed.clientservice.model.Shipment;
import com.trilogyed.clientservice.util.feign.ShipmentClient;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ServiceLayerTest {

    ServiceLayer service;

    ShipmentClient client;



    @Before

    public void setUp() throws Exception {


        setUpConsumerClientMock();
        service = new ServiceLayer(client);



    }



    public void setUpConsumerClientMock() {

        client = mock(ShipmentClient.class);

        Shipment c = new Shipment();

        c.setTrackingNumber("1");

        c.setName("Test");



        Shipment c2 = new Shipment();

//        c.setTrackingId(1);

        c.setName("Test");

        List<Shipment> cList = new ArrayList<>();

        cList.add(c);



        doReturn(c).when(client).addShipment(c2);

        doReturn(c).when(client).getShipment("1");



    }



    @Test

    public void getConsumer(){

        Shipment consumer = new Shipment();

        consumer.setTrackingNumber("1");

        consumer.setName("Test");

        service.add(consumer);



        Shipment c = service.get(consumer.getTrackingNumber());



        assertEquals(c, consumer);



    }




}
