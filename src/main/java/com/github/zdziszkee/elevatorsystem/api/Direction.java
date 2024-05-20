package com.github.zdziszkee.elevatorsystem.api;

public enum Direction {
    UP,
    DOWN,
    NONE;

    public static Direction getDirection(int source, int destination) {
        if(source == destination) return NONE;
        if(source < destination) return UP;
        return DOWN;
    }
}
