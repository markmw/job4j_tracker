package ru.job4j.tracker.oop;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxTest {

    @Test
    public void whenMax3To2Then3() {
        Max max = new Max();
        int result = max.max(2, 3);
        int expected = 3;
        Assert.assertEquals(expected, result);
    }

    @Test
    public void whenMax3And2And1Then3() {
        Max max = new Max();
        int result = max.max(3, 2, 1);
        int expected = 3;
        Assert.assertEquals(expected, result);
    }

    @Test
    public void whenMax3And2And1And5Then5() {
        Max max = new Max();
        int result = max.max(3, 2, 1, 5);
        int expected = 5;
        Assert.assertEquals(expected, result);
    }
}