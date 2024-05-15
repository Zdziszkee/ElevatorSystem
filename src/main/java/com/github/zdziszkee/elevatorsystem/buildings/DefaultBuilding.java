package com.github.zdziszkee.elevatorsystem.buildings;

import com.github.zdziszkee.elevatorsystem.api.Building;
import com.github.zdziszkee.elevatorsystem.api.ElevatorScheduler;

public class DefaultBuilding implements Building {
    private final int minimumFloor;
    private final int maximumFloor;
    private final int numberOfElevators;

    private final ElevatorScheduler scheduler;

    public DefaultBuilding(int minimumFloor, int maximumFloor, int numberOfElevators, ElevatorScheduler scheduler) {
        this.minimumFloor = minimumFloor;
        this.maximumFloor = maximumFloor;
        this.numberOfElevators = numberOfElevators;
        this.scheduler = scheduler;
    }


    @Override
    public int getMinimumFloor() {
        return minimumFloor;
    }

    @Override
    public int getMaximumFloor() {
        return maximumFloor;
    }

    @Override
    public int getNumberOfElevators() {
        return numberOfElevators;
    }

    @Override
    public ElevatorScheduler getElevatorScheduler() {
        return scheduler;
    }
}