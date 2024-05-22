package com.github.zdziszkee.elevatorsystem.api;

import java.util.*;

public class Elevator implements Simulation {

    private static int counter = 0;
    private final int id = counter++;

    private final Deque<ElevatorRequest> requests = new ArrayDeque<>();
    protected int currentFloor;
    protected Direction currentDirection = Direction.NONE;
    public Elevator(int startingFloor) {
        this.currentFloor = startingFloor;
    }

    @Override
    public void step() {
        if (requests.isEmpty()) return;

        final ElevatorRequest request = requests.peek();

        boolean isSourceVisited = request.isSourceVisited();
        final int targetFloor = isSourceVisited ? request.getDestination() : request.getSource();

        Direction direction = Direction.getDirection(currentFloor, targetFloor);
        if (direction == Direction.UP) {
            currentFloor++;
        } else if (direction == Direction.DOWN) {
            currentFloor--;
        } else if (direction == Direction.NONE) {
            if (currentFloor == targetFloor) {
                if (!isSourceVisited) {
                    request.setWasSourceVisited(true);
                } else {
                    requests.removeFirst();
                }
            }
        }
        currentDirection = direction;
    }


    public void addRequest(ElevatorRequest request) {
        requests.add(request);
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

    public Deque<ElevatorRequest> getRequests() {
        return requests;
    }
}
