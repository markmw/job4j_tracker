package ru.job4j.tracker.oop;

public class Max {
    private int first;
    private int second;
    private int third;
    private int fourth;

    public int max(int first, int second) {
        return first > second ? first : second;
    }

    public int max(int first, int second, int third) {
        return max(first, max(second, third));
    }

    public int max(int first, int second, int third, int fourth) {
        return max(first, max(second, third, fourth));
    }
}
