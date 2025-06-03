package Basics_of_Java.OOP.Abstraction;

import Basics_of_Java.OOP.Abstraction.Vehicle;

public abstract class Vehicle implements Transport {
    private int noOfTires;

    public abstract void makeStartSound();


    public Vehicle(int noOfTires) {
        this.noOfTires = noOfTires;
    }

    public int getNoOfTires() {
        return noOfTires;
    }

    public void setNoOfTires(int noOfTires) {
        this.noOfTires = noOfTires;
    }

    public void commute() {
        System.out.println("going.....");
    }
}
