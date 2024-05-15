package com.github.zdziszkee.elevatorsystem.api;

import java.util.Set;

public interface ElevatorScheduler {

    Set<Elevator> getElevators();

    default void step(){

    }
}
