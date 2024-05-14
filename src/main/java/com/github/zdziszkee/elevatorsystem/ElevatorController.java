package com.github.zdziszkee.elevatorsystem;

import java.util.ArrayDeque;
import java.util.Queue;

public class ElevatorController {
    private final Queue<ElevatorRequest> requests = new ArrayDeque<>();

    public final void requestElevator(int sourceFloor, int destinationFloor) {
        requests.add(new ElevatorRequest(sourceFloor, destinationFloor));
    }
}
