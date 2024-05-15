package com.github.zdziszkee.elevatorsystem.api;

public interface Building {

    int getMinimumFloor();

    int getMaximumFloor();

    int getNumberOfElevators();

    ElevatorScheduler getElevatorScheduler();


}
