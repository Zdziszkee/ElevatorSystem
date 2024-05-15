package com.github.zdziszkee.elevatorsystem.api;

import java.util.TreeSet;

public class Elevator implements Simulation {

    private static int counter = 0;
    private final int id = counter++;


    /**
     * Represents next destinations this elevator is going to stop on.
     */
    private final TreeSet<Integer> destinations = new TreeSet<>(Integer::compare);
    private final TreeSet<Integer> sources = new TreeSet<>(Integer::compare);

    /**
     * Represents the floor this elevator is in current step.
     */
    private int currentFloor;
    private Direction currentDirection = Direction.NONE;

    public Elevator(int startingFloor) {
        this.currentFloor = startingFloor;
    }

    public void addDestination(int destination) {
        destinations.add(destination);
    }

    public void addSource(int destination) {
        sources.add(destination);
    }
    public TreeSet<Integer> getDestinations() {
        return destinations;
    }

    public TreeSet<Integer> getSources() {
        return sources;
    }

    public int getId() {
        return id;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    @Override
    public void step(StringBuilder stringBuilder) {

        if (destinations.isEmpty()) return;

        final int nextDestination = destinations.first();

        if (!sources.isEmpty() && sources.first() == currentFloor) {
            sources.removeFirst();
            currentDirection = Direction.NONE;
            return;
        }

        final Direction direction = Direction.getDirection(currentFloor, nextDestination);

        if (direction == Direction.UP) {
            currentFloor++;
        } else if (direction == Direction.DOWN) {
            currentFloor--;
        } else if (direction == Direction.NONE) {
            destinations.remove(nextDestination);
        }

        currentDirection = direction;

        stringBuilder.append(this);
    }

    @Override
    public String toString() {
        return "Elevator{" +
                "currentDirection=" + currentDirection +
                ", currentFloor=" + currentFloor +
                ", id=" + id +
                '}';
    }
}
