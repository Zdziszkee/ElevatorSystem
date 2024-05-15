package com.github.zdziszkee.elevatorsystem.api;

public interface DestinationDispatchScheduler extends ElevatorScheduler {
    void schedule(int sourceFloor, int destinationFloor);
}