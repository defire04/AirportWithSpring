package com.example.Start;

import com.example.controllers.BorderService;
import com.example.factory.PlaneFactory;
import com.example.models.Plane;

import java.util.List;

public class Dispatcher {
    public static void main(String[] args) {
        List<Plane> arrivalList = PlaneFactory.createPlanes();
        System.out.println("Arrive " + arrivalList.size() + " planes");


//        org.example.Start.Tester.setFamilyForTest(new Family("Millers", "Kiev", 4));
//        org.example.Start.Tester.setEveryoneTravelToOneDirection(arrivalList, "Kiev");

        BorderService.arrivalOfFamiliesToAirport(arrivalList);

        Tester.getTestHowManyPeopleTravelToEachDirection();
//        org.example.Start.Tester.getAllFamilies();

    }
}


