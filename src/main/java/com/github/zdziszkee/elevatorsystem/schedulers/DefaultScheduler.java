package com.github.zdziszkee.elevatorsystem.schedulers;

import com.github.zdziszkee.elevatorsystem.api.*;
import com.github.zdziszkee.elevatorsystem.renderers.ConsoleRenderer;

import java.util.*;

public class DefaultScheduler implements ElevatorScheduler {

    private final Set<Elevator> elevators = new LinkedHashSet<>();
    private final int minimumFloor;
    private final int maximumFloor;
    private final Renderer renderer = new ConsoleRenderer();
    public void step(){
        getElevators().forEach(Elevator::step);
        renderer.render(this);

    }
    public DefaultScheduler(int minFloorInclusive, int maxFloorInclusive, int elevatorsCount) {
        for (int i = 0; i < elevatorsCount; i++) {
            elevators.add(new Elevator(i));
        }
        this.minimumFloor = minFloorInclusive;
        this.maximumFloor = maxFloorInclusive;
    }

    public final void schedule(int sourceFloor, int destinationFloor) {
        final Optional<Elevator> bestElevator = elevators.stream().min((first, second) -> Integer.compare(calculateCost(first, sourceFloor), calculateCost(second, sourceFloor)));
        final Elevator elevator = bestElevator.orElseThrow(() -> new IllegalStateException("No elevator found"));
        elevator.addRequest(new ElevatorRequest(sourceFloor, destinationFloor));
    }

    private int calculateCost(final Elevator elevator, final int sourceFloor) {
        final int currentFloor = elevator.getCurrentFloor();
        final Queue<ElevatorRequest> destinations = elevator.getRequests();
        final int elevatorDistanceFromSourceFloor = Math.abs(currentFloor - sourceFloor);
        return destinations.size() + elevatorDistanceFromSourceFloor ;
    }

    @Override
    public Set<Elevator> getElevators() {
        return Collections.unmodifiableSet(elevators);
    }

    @Override
    public void addElevator(Elevator elevator) {
        elevators.add(elevator);
    }

    @Override
    public int getMinimumFloor() {
        return this.minimumFloor;
    }

    @Override
    public int getMaximumFloor() {
        return this.maximumFloor;
    }

}
