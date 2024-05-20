package com.github.zdziszkee.elevatorsystem.api;


import java.util.Set;

public interface ElevatorScheduler extends Simulation {

    void schedule(int sourceFloor, int destinationFloor);

    Set<Elevator> getElevators();

    void  addElevator(Elevator elevator);

    int getMinimumFloor();

    int getMaximumFloor();
}
