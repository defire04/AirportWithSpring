package com.example.dao;

import com.example.models.Family;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class FamilyDaoWithJdbc {

    private final static String URL = "jdbc:postgresql://localhost:5432/passengers_db";
    private final static String USERNAME = "postgres";
    private final static String PASSWORD = "0979727877";
    private static Connection connection;


    static {
        try {
            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try{
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Family> getFamiliesList(){
        List<Family> families = new ArrayList<>();
        String SQL = "SELECT * FROM passengers";
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);

            while(resultSet.next()){
                Family family = new Family();

                family.setId(resultSet.getInt("id"));
                family.setName(resultSet.getString("family"));
                family.setTravelTo(resultSet.getString("travel_to"));
                family.setMembers(resultSet.getInt("members"));

                families.add(family);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return families;
    }
}