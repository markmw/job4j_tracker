package ru.job4j.ex;

import org.junit.Test;
import ru.job4j.ex.Fact;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenCalcMinusOneThenException() {
        Fact calc = new Fact();
        calc.calc(-1);
    }
}