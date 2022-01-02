package ru.job4j.tracker.ex;

import org.junit.Test;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenCalcMinusOneThenException() {
        Fact calc = new Fact();
        calc.calc(-1);
    }
}