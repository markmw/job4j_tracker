package ru.job4j.poly;

public class Airplane implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " flies in the Sky");
    }

    @Override
    public void fuel() {
        System.out.println(getClass().getSimpleName() + " used aviation fuel");
    }
}
