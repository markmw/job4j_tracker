package ru.job4j.poly;

public class Autobus implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " driving in the road");
    }

    @Override
    public void fuel() {
        System.out.println(getClass().getSimpleName() + " used diesel");
    }
}
