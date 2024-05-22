package com.github.zdziszkee.elevatorsystem;


import com.github.zdziszkee.elevatorsystem.schedulers.DefaultScheduler;

public class ElevatorSystem {
    public static void main(String[] args) {
        DefaultScheduler scheduler = new DefaultScheduler(0,10,16);
        scheduler.schedule(0,2);
        scheduler.step();
        scheduler.step();
        scheduler.step();
        scheduler.step();

    }
    }

