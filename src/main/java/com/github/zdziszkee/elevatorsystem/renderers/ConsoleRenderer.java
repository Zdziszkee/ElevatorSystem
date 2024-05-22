package com.github.zdziszkee.elevatorsystem.renderers;

import com.github.zdziszkee.elevatorsystem.api.Elevator;
import com.github.zdziszkee.elevatorsystem.api.ElevatorRequest;
import com.github.zdziszkee.elevatorsystem.api.ElevatorScheduler;
import com.github.zdziszkee.elevatorsystem.api.Renderer;

import java.util.Set;
import java.util.stream.Collectors;

public class ConsoleRenderer implements Renderer {
    private static int step = 0;
    @Override
    public void render(ElevatorScheduler scheduler) {
        Set<Elevator> elevators = scheduler.getElevators();
        int minimumFloor = scheduler.getMinimumFloor();
        int maximumFloor = scheduler.getMaximumFloor();

        StringBuilder builder = new StringBuilder();
        for (int floor = maximumFloor; floor >= minimumFloor; floor--) {
            final int finalFloor = floor;
            Set<Elevator> elevatorsOnThisFloor = elevators.stream().filter(elevator -> elevator.getCurrentFloor() == finalFloor).collect(Collectors.toSet());
            builder.append("Step ").append(step).append(" ");
            builder.append("Floor ").append(floor).append(": ");
            elevatorsOnThisFloor.forEach(elevator -> {
                builder.append("[");
                builder.append("ID: ");
                builder.append(elevator.getId());
                builder.append(" Destination: ");
                ElevatorRequest request = elevator.getRequests().peek();
                if (request != null) {
                    builder.append(request.isSourceVisited() ? request.getDestination() : request.getSource());
                }
                builder.append(" Direction: ");
                builder.append(elevator.getCurrentDirection());
                builder.append("] ");
            });
            builder.append("\n");
        }
        System.out.println(builder);
        step++;
    }

}
