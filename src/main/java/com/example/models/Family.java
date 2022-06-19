package com.example.models;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Family {
    private int id;
    @NotEmpty(message = "Surname should not be empty")
    @Size(min = 2, max = 40, message = "Surname should be between 2 and 40 characters")
    private String name;
    @NotEmpty(message = "Travel to should not be empty")
    @Size(min = 2, max = 40, message = "Travel to should be more than 2 characters")
    private String travelTo;
    @Min(value = 1, message = "Members should be greater then 1")
    private int members;
    private boolean isFamilyInBus = false;

    public Family() {
    }

    public Family(int id, String name, String travelTo, int members) {
        this.id = id;
        this.name = name;
        this.travelTo = travelTo;
        this.members = members;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTravelTo() {
        return travelTo;
    }

    public void setTravelTo(String travelTo) {
        this.travelTo = travelTo;
    } // fot org.example.Start.Tester

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }

    public boolean getIsFamilyInBus() {
        return isFamilyInBus;
    }

    public void setFamilyInBus(boolean familyInBus) {
        isFamilyInBus = familyInBus;
    }

    public boolean isFamilyInBus() {
        return isFamilyInBus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return members == family.members && isFamilyInBus == family.isFamilyInBus && Objects.equals(name, family.name) && Objects.equals(travelTo, family.travelTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, travelTo, members, isFamilyInBus);
    }

    @Override
    public String toString() {
        return "Family = " + this.name +
                " TravelTo=" + this.travelTo +
                " Members=" + this.members + " ";
    }
}
