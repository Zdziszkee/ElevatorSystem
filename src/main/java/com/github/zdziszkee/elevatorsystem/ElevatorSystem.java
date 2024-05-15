package com.github.zdziszkee.elevatorsystem;

import com.github.zdziszkee.elevatorsystem.api.DestinationDispatchScheduler;
import com.github.zdziszkee.elevatorsystem.buildings.DefaultBuilding;
import com.github.zdziszkee.elevatorsystem.schedulers.DefaultDestinationDispatchScheduler;

public class ElevatorSystem {
    public static void main(String[] args) {
        DefaultBuilding building = new DefaultBuilding(0, 10, 3, new DefaultDestinationDispatchScheduler(0, 10, 3));
        DestinationDispatchScheduler elevatorScheduler = building.getElevatorScheduler();
        StringBuilder builder = new StringBuilder();
        elevatorScheduler.schedule(0, 2);
        elevatorScheduler.step(builder);
        elevatorScheduler.schedule(4, 2);
        elevatorScheduler.step(builder);
        elevatorScheduler.step(builder);
        elevatorScheduler.schedule(3, 4);
        elevatorScheduler.step(builder);
        elevatorScheduler.step(builder);
        elevatorScheduler.step(builder);
        elevatorScheduler.step(builder);
        elevatorScheduler.step(builder);

        elevatorScheduler.step(builder);

        System.out.println(builder.toString());

    }
    }

