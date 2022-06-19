package com.example.models;

import java.util.List;

public class Plane implements Runnable {
    public static final int SEATS = 40;
    private final int flightNumber;
    private List<Family> families;

    public Plane(List<Family> families, int flightNumber) {
        this.families = families;
        this.flightNumber = flightNumber;
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
        System.out.println(this.families.size() + " families arrived from aircraft number " + this.flightNumber + "!\n" +
                "List of visiting families:" + this.families +
                "\n----------------------------------------------");
    }
}
