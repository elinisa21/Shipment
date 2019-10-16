package com.trilogyed.uspsshipmentservice;

import com.trilogyed.uspsshipmentservice.dao.ShipmentDao;
import com.trilogyed.uspsshipmentservice.model.Shipment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DaoTest {
    @Autowired
    ShipmentDao dao;

    @Before
    public void setUp() throws Exception {
        // clean out the test db
        List<Shipment> tList = dao.getAll();

        tList.stream()
                .forEach(shipment -> dao.deleteShipment(shipment.getId()));
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    @Transactional
    public void addGetDeleteTask() {

        Shipment shipment = new Shipment();
        shipment.setName("ugy");
           shipment.setTrackingNumber("123a");

        shipment = dao.createShipment(shipment);

        Shipment shipment1 = dao.getShipment(shipment.getTrackingNumber());
        assertEquals(shipment, shipment1);

        dao.deleteShipment(shipment.getId());

        shipment1 = dao.getShipment(shipment.getTrackingNumber());
        assertNull(shipment1);
    }

}
