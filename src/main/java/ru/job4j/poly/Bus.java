package ru.job4j.poly;

public class Bus implements Transport {
    private int count;
    private int fuel;
    private int price;
    private boolean driver = true;

    @Override
    public void drive() {
        this.driver = false;
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
