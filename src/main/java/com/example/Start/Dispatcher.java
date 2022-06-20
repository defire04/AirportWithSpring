package com.example.Start;

import java.util.List;
import com.example.models.Plane;
import com.example.controllers.BorderService;
import com.example.controllers.PlanesController;

public class Dispatcher {
    public static void main(String[] args) {


        List<Plane> arrivalList = PlanesController.createPlanes();

        System.out.println("Arrive " + arrivalList.size() + " planes");
        BorderService.arrivalOfFamiliesToAirport(arrivalList);
        Tester.getTestHowManyPeopleTravelToEachDirection();




    }
}


