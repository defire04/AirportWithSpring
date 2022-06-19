package controllers;

import models.Plane;
import models.Family;
import java.util.List;
import java.util.ArrayList;

public class BorderService {
    public static List<Family> allArrivingFamiliesAtAirport = new ArrayList<>();

    public static void arrivalOfFamiliesToAirport(List<Plane> planeList) {
        planeList.forEach(plane -> allArrivingFamiliesAtAirport.addAll(plane.getFamilies()));
        controllers.TourController.sortingPassengersByCity(allArrivingFamiliesAtAirport);
    }
}
