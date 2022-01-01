package ru.job4j.tracker.oop;

public class College {
    public static void main(String[] args) {
        Freshman man = new Freshman();
        Student std = man;
        Object obj = man;
        System.out.println("It's up casting!");
    }
}
