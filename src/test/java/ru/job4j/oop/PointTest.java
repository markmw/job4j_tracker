package ru.job4j.oop;

import org.junit.Test;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

public class PointTest {

    @Test
    public void distance() {
        Point a = new Point(2, 0);
        Point b = new Point(0, 2);
        double rsl = a.distance(b);
        assertThat(rsl, closeTo(2.828, 0.001));
    }

    @Test
    public void distanceTest2() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 0);
        double rsl = a.distance(b);
        assertThat(rsl, closeTo(0, 0.001));
    }

    @Test
    public void distance3d() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(1, 0, 0);
        double rsl = a.distance3d(b);
        assertThat(rsl, closeTo(1, 0.001));
    }

    @Test
    public void distance3dTest2() {
        Point a = new Point(2, 0, 0);
        Point b = new Point(2, 0, 0);
        double rsl = a.distance3d(b);
        assertThat(rsl, closeTo(0, 0.001));
    }
}