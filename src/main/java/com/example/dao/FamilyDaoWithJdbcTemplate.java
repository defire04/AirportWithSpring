package com.example.dao;

import com.example.models.Family;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class FamilyDaoWithJdbcTemplate {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FamilyDaoWithJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Family> index() {
        return jdbcTemplate.query("SELECT * FROM passengers",  new FamilyMapper());
    }

    public Family show(int id) {
        return jdbcTemplate.query("SELECT * FROM passengers WHERE id=?", new Object[]{id},
                        new FamilyMapper())
                .stream().findAny().orElse(null);
    }

    public void save(Family family) {
        jdbcTemplate.update("INSERT INTO passengers(family, travel_to, members) VALUES(?,?,?)",
                family.getName(), family.getTravelTo(), family.getMembers());
    }

    public void update(int id, Family updatedFamily) {
        jdbcTemplate.update("UPDATE passengers Set family=?, travel_to=?, members=? WHERE id=?",
                updatedFamily.getName(), updatedFamily.getTravelTo(), updatedFamily.getMembers(), id);

    }

    public void delete(int id) {
        jdbcTemplate.update( "DELETE FROM passengers WHERE id=?", id);
    }


}

