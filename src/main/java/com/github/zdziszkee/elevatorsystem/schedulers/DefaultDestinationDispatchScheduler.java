package com.github.zdziszkee.elevatorsystem.schedulers;

import com.github.zdziszkee.elevatorsystem.api.DestinationDispatchScheduler;
import com.github.zdziszkee.elevatorsystem.api.Elevator;

import java.util.*;

public class DefaultDestinationDispatchScheduler implements DestinationDispatchScheduler {

    private final Set<Elevator> elevators = new HashSet<>();

    public DefaultDestinationDispatchScheduler(int minFloorInclusive, int maxFloorInclusive, int elevatorsCount) {
        for (int i = 0; i < elevatorsCount; i++) {
            elevators.add(new Elevator(i));
        }
    }

    public final void schedule(int sourceFloor, int destinationFloor) {
        Optional<Elevator> bestElevator = elevators.stream().min((first, second) -> Integer.compare(calculateCost(first, sourceFloor, destinationFloor), calculateCost(second, sourceFloor, destinationFloor)));
        bestElevator.ifPresent(elevator -> elevator.addDestination(destinationFloor));
    }

    private int calculateCost(Elevator elevator, int sourceFloor, int destinationFloor) {
        final int currentFloor = elevator.getCurrentFloor();
        final TreeSet<Integer> destinations = elevator.getDestinations();
        //criteria #1
        int elevatorDistanceFromSourceFloor = Math.abs(currentFloor - sourceFloor);
        //criteria #2
        int elevatorDestinationsDistance = Math.abs(destinations.last() - destinationFloor);
        //criteria #3
        return elevatorDestinationsDistance + elevatorDistanceFromSourceFloor;
    }

    @Override
    public Set<Elevator> getElevators() {
        return new HashSet<>(elevators);
    }

    @Override
    public void step() {

    }
}
