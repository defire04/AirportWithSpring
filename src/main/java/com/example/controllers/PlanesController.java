package com.example.controllers;

import com.example.dao.FamilyDaoWithJdbc;
import com.example.models.Family;
import com.example.models.Plane;

import java.util.ArrayList;
import java.util.List;

public class PlanesController {

    private static FamilyDaoWithJdbc familyDaoWithJdbc = new FamilyDaoWithJdbc();


    public static List<Plane> createPlanes() {
        List<Plane> planeResultList = new ArrayList<>();

        for (int i = 0; i < (int) (Math.random() * 3) + 3; i++) {
//        for (int i = 0; i < 2; i++) {
            planeResultList.add(new Plane(new ArrayList<>(), i + 1));
        }


        for (Family family : familyDaoWithJdbc.getFamiliesList()) {
            for (Plane plane : planeResultList) {
                if (!family.isFamilyInPlane()) {
                    if (plane.getPlaceLeft() - family.getMembers() > -1) {
                        plane.setPlaceLeft(plane.getPlaceLeft() - family.getMembers());
                        plane.getFamilies().add(family);
                        family.setFamilyInPlane(true);
                    }
                }
            }
        }


        return planeResultList;
    }
}
