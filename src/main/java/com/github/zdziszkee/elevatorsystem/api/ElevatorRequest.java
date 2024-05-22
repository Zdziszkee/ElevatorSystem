package com.github.zdziszkee.elevatorsystem.api;

import java.util.Objects;

public class ElevatorRequest {
    private final int source;
    private final int destination;
    private boolean wasSourceVisited = false;

    public ElevatorRequest(int source, int destination) {
        this.source = source;
        this.destination = destination;
    }

    public int getSource() {
        return source;
    }

    public int getDestination() {
        return destination;
    }

    public boolean isSourceVisited() {
        return wasSourceVisited;
    }

    public void setWasSourceVisited(boolean wasSourceVisited) {
        this.wasSourceVisited = wasSourceVisited;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElevatorRequest that = (ElevatorRequest) o;
        return source == that.source && destination == that.destination;
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, destination);
    }
}
