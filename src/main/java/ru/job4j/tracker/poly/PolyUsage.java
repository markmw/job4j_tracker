package ru.job4j.tracker.poly;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle airplane = new Airplane();
        Vehicle train = new Train();
        Vehicle autobus = new Autobus();
        Vehicle[] vehicles = new Vehicle[] {airplane, train, autobus};
        for (Vehicle v : vehicles) {
            v.move();
            v.fuel();
        }
    }
}
