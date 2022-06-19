package com.example.factory;


import com.example.models.Family;
import com.example.models.Plane;

import java.util.ArrayList;
import java.util.List;

public class FamilyFactory {
    public static int ID = 0;
    public static List<Family> createFamilies() {

        List<Family> familiesInPlane = new ArrayList<>();
        List<String> surnameList = createSurnames();

        String[] cities = {"Kalush", "Kosiv", "Galych", "Kolomia"};

        int countOfMembers = 0;
        int countPeopleInPlane = 0;

        while (!(countPeopleInPlane == Plane.SEATS)) {
            countOfMembers = (int) (Math.random() * 3) + 1;
            countPeopleInPlane += countOfMembers;
            if (countPeopleInPlane < Plane.SEATS + 1) {
                familiesInPlane.add(new Family(ID++,
                        surnameList.get((int) (Math.random() * surnameList.size())),
                        cities[(int) (Math.random() * 4)],
                        countOfMembers));
            } else {
                countPeopleInPlane -= countOfMembers;
            }
        }
        return familiesInPlane;
    }


    private static List<String> createSurnames() {
        List<String> resultSurnameSet = new ArrayList<>();
        String[] surnameCreator = "abcdefghijklmnopqrstuvwxyz".split("");

        for (String symbol : surnameCreator) {
            for (String symbol2 : surnameCreator) {
                resultSurnameSet.add(symbol + symbol2);
            }
        }
        return resultSurnameSet;
    }
}

