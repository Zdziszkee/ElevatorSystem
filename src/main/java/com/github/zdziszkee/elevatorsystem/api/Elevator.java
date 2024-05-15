package com.github.zdziszkee.elevatorsystem.api;
import java.util.TreeSet;

public class Elevator {

    private static int counter = 0;
    private final int id = counter++;


    /**
     * Represents next destinations this elevator is going to stop on.
     */
    private final TreeSet<Integer> destinations = new TreeSet<>(Integer::compare);

    /**
     * Represents the floor this elevator is in current step.
     */
    private int currentFloor;

    public Elevator(int startingFloor) {
        this.currentFloor = startingFloor;
    }

    public void addDestination(int destination) {
        destinations.add(destination);
    }

    public TreeSet<Integer> getDestinations() {
        return new TreeSet<>(destinations);
    }

    public int getId() {
        return id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }
}
