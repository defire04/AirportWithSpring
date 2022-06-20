package com.example.models;

import java.util.List;

public class Plane implements Runnable {
    public static final int SEATS = 40;
    private final int flightNumber;
    private List<Family> families;

    private int placeLeft;

    public Plane(List<Family> families, int flightNumber) {
        this.families = families;
        this.flightNumber = flightNumber;
        this.placeLeft = SEATS;
        new Thread(this).start();
    }

    public List<Family> getFamilies() {
        return families;
    }

    public void setFamilies(List<Family> families) { // Чтобы добавить семью для теста
        this.families = families;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public int getPlaceLeft() {
        return placeLeft;
    }

    public void setPlaceLeft(int placeLeft) {
        this.placeLeft = placeLeft;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "families=" + this.families +
                ", flightNumber=" + this.flightNumber +
                '}';
    }

    @Override
    public void run() {
        infoAboutPeopleAboard();
    }

    public void infoAboutPeopleAboard() {
        System.out.println(" The plane "+ this.flightNumber +" has started landing! " +
                "\n----------------------------------------------");
    }
}
