package com.example.controllers;




import com.example.models.Family;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class TourController {
    public static void sortingPassengersByCity(List<Family> familyList) {
        System.out.println("Total people arrived " + familyList.stream().collect(Collectors.summarizingLong(Family::getMembers)).getSum());

        Map<String, List<Family>> sortedToCityMap = familyList.stream()
                .collect(Collectors.groupingBy(Family::getTravelTo, Collectors.toList()));

        for (Map.Entry<String, List<Family>> cityTo : sortedToCityMap.entrySet()) {
            new com.example.models.TourToCity(cityTo.getKey(), cityTo.getValue());
        }
    }
}
