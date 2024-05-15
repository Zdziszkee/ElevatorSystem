package com.github.zdziszkee.elevatorsystem.schedulers;

import com.github.zdziszkee.elevatorsystem.api.DestinationDispatchScheduler;
import com.github.zdziszkee.elevatorsystem.api.Elevator;

import java.util.*;

public class DefaultDestinationDispatchScheduler implements DestinationDispatchScheduler {

    private final Set<Elevator> elevators = new HashSet<>();
    static int counter = 0;
    public void step(StringBuilder builder){
        builder.append("Step ").append(counter).append(": ");
        getElevators().forEach(elevator -> elevator.step(builder));
        builder.append("\n");
        counter++;
    }
    public DefaultDestinationDispatchScheduler(int minFloorInclusive, int maxFloorInclusive, int elevatorsCount) {
        for (int i = 0; i < elevatorsCount; i++) {
            elevators.add(new Elevator(i));
        }
    }

    public final void schedule(int sourceFloor, int destinationFloor) {
        final Optional<Elevator> bestElevator = elevators.stream().min((first, second) -> Integer.compare(calculateCost(first, sourceFloor, destinationFloor), calculateCost(second, sourceFloor, destinationFloor)));
        final Elevator elevator = bestElevator.orElseThrow(() -> new IllegalStateException("No elevator found"));
        elevator.addDestination(sourceFloor);
        elevator.addDestination(destinationFloor);
    }

    private int calculateCost(final Elevator elevator, final int sourceFloor, final int destinationFloor) {
        final int currentFloor = elevator.getCurrentFloor();
        final TreeSet<Integer> destinations = elevator.getDestinations();
        if (destinations.isEmpty()) {
            return 0;
        }

        //criteria #1
        final int elevatorDistanceFromSourceFloor = Math.abs(currentFloor - sourceFloor);
        //criteria #2
        final int elevatorDistanceFromDestinationFloor = Math.abs(currentFloor - destinationFloor);
        //criteria #3
        return elevatorDistanceFromDestinationFloor + elevatorDistanceFromSourceFloor;
    }

    @Override
    public Set<Elevator> getElevators() {
        return Collections.unmodifiableSet(elevators);
    }

}
