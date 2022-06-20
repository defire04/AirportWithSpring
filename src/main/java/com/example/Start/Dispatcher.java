package com.example.Start;

import com.example.controllers.BorderService;
import com.example.controllers.PlanesController;
import com.example.dao.FamilyDaoWithJdbc;
import com.example.factory.PlaneFactory;
import com.example.models.Family;
import com.example.models.Plane;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Dispatcher {
    public static void main(String[] args) {


        List<Plane> arrivalList = PlanesController.createPlanes();
//        List<Plane> arrivalList = PlaneFactory.createPlanes();
        System.out.println("Arrive " + arrivalList.size() + " planes");
        BorderService.arrivalOfFamiliesToAirport(arrivalList);
        Tester.getTestHowManyPeopleTravelToEachDirection();
    }
}


