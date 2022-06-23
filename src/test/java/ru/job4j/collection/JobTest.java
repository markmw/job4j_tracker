package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class JobTest {
    @Test
    public void whenAscByName() {
        List<Job> names = Arrays.asList(
                new Job("Impl task", 2),
                new Job("Fix bug", 0),
                new Job("Rm disc", 1)
        );
        List<Job> expected = Arrays.asList(
                new Job("Fix bug", 0),
                new Job("Impl task", 2),
                new Job("Rm disc", 1)
        );
        Collections.sort(names, new JobAscByName());
        assertEquals(expected, names);
    }

    @Test
    public void whenDescByName() {
        List<Job> names = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Impl task", 2),
                new Job("Rm disc", 0)
        );
        List<Job> expected = Arrays.asList(
                new Job("Rm disc", 0),
                new Job("Impl task", 2),
                new Job("Fix bug", 1)
        );
        Collections.sort(names, new JobDescByName());
        assertEquals(expected, names);
    }

    @Test
    public void whenAscByPriority() {
        List<Job> names = Arrays.asList(
                new Job("Impl task", 2),
                new Job("Fix bug", 1),
                new Job("rm disc", 0)
        );
        List<Job> expected = Arrays.asList(
                new Job("rm disc", 0),
                new Job("Fix bug", 1),
                new Job("Impl task", 2)
        );
        Collections.sort(names, new JobAscByPriority());
        assertEquals(expected, names);
    }

    @Test
    public void whenDescByPriority() {
        List<Job> names = Arrays.asList(
                new Job("rm disc", 0),
                new Job("Fix bug", 1),
                new Job("Impl task", 2)
        );
        List<Job> expected = Arrays.asList(
                new Job("Impl task", 2),
                new Job("Fix bug", 1),
                new Job("rm disc", 0)
        );
        Collections.sort(names, new JobDescByPriority());
        assertEquals(expected, names);
    }

    @Test
    public void whenDescByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 1),
                new Job("Impl task", 0)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenAscByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix Bug", 0),
                new Job("Fix Bug", 1)
        );
        assertThat(rsl, lessThan(1));
    }

}