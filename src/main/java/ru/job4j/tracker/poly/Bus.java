package ru.job4j.tracker.poly;

public class Bus implements Transport {
    private int count;
    private int fuel;
    private int price;

    @Override
    public void drive() {

    }

    @Override
    public void passengers(int count) {
        this.count = count;
    }

    @Override
    public int refuel(int fuel) {
        this.fuel = fuel;
        return price;
    }
}
