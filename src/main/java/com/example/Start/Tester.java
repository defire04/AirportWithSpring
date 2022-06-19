package com.example.Start;


import com.example.controllers.BorderService;
import com.example.models.Family;
import com.example.models.Plane;

import java.util.List;
import java.util.stream.Collectors;



public class Tester {
    public static void getTestHowManyPeopleTravelToEachDirection() {
        BorderService.allArrivingFamiliesAtAirport.stream().collect(Collectors.groupingBy(
                        Family::getTravelTo, Collectors.summingInt(Family::getMembers)))
                .forEach((key, value) -> System.out.println(key + " " + value));
    }

    public static void getAllFamilies() {
        BorderService.allArrivingFamiliesAtAirport.forEach(System.out::println);
    }

    public static void setFamilyForTest(Family family) {
        BorderService.allArrivingFamiliesAtAirport.add(family);
    }

    public static void setEveryoneTravelToOneDirection(List<Plane> arrivalList, String travelTo){
        arrivalList.forEach(plane -> plane.getFamilies().forEach(family -> family.setTravelTo(travelTo)));
    }
}
