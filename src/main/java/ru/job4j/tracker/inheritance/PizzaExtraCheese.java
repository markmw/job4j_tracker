package ru.job4j.tracker.inheritance;

public class PizzaExtraCheese extends Pizza {
    private static final String EXTRACHEESE = " + extra cheese";

    @Override
    public String name() {
        return super.name() + EXTRACHEESE;
    }
}
