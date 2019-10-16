package com.trilogyed.uspsshipmentservice.dao;

import com.trilogyed.uspsshipmentservice.model.Shipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ShipmentDaoJdbcTemplateImpl implements ShipmentDao {

    public static final String INSERT_SHIPMENT =
            "insert into usps_shipment_service (name, tracking_number) values (?, ?)";
    public static final String SELECT_SHIPMENT =
            "select * from usps_shipment_service where tracking_number = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ShipmentDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }



    @Override
    @Transactional
    public Shipment createShipment(Shipment shipment) {

        jdbcTemplate.update(INSERT_SHIPMENT,
                shipment.getName(),
                shipment.getTrackingNumber());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        shipment.setId(id);
        return shipment;    }

    @Override
    public Shipment getShipment(String trackingNumber) {
        try {
            return jdbcTemplate.queryForObject(SELECT_SHIPMENT, this::mapRowToShipment, trackingNumber);
        } catch (EmptyResultDataAccessException ex) {
            // if nothing is returned for this query, just return null
            return null;
        }
    }

    private Shipment mapRowToShipment (ResultSet rs, int rowNum) throws SQLException {
        Shipment shipment = new Shipment();
        shipment.setId(rs.getInt("shipment_id"));
        shipment.setName(rs.getString("name"));
        shipment.setTrackingNumber(rs.getString("tracking_number"));

        return shipment;
    }
}
