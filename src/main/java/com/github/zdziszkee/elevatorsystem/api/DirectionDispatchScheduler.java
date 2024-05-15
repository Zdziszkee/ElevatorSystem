package com.github.zdziszkee.elevatorsystem.api;

public interface DirectionDispatchScheduler extends ElevatorScheduler{

    void schedule(int sourceFloor, Direction direction);

}
