package com.example.dao;

import com.example.models.Family;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;



public class FamilyMapper implements RowMapper<Family> {
    @Override
    public Family mapRow(ResultSet resultSet, int i) throws SQLException {
        Family family = new Family();

        family.setId(resultSet.getInt("id"));
        family.setName(resultSet.getString("family"));
        family.setTravelTo(resultSet.getString("travel_to"));
        family.setMembers(resultSet.getInt("members"));

        return family;
    }
}
