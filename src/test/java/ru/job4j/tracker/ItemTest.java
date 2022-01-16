package ru.job4j.tracker;

import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.*;

public class ItemTest {
    @Test
    public void whenAcsSort() {
        List<Item> items = Arrays.asList(
                new Item(7, "Keyboard"),
                new Item(2, "Mouse"),
                new Item(8, "Headphones")
        );
        List<Item> expected = Arrays.asList(
                new Item(2, "Mouse"),
                new Item(7, "Keyboard"),
                new Item(8, "Headphones")
        );
        Collections.sort(items);
        assertEquals(items, expected);
    }

    @Test
    public void whenDescSort() {
        List<Item> items = Arrays.asList(
                new Item(7, "Keyboard"),
                new Item(2, "Mouse"),
                new Item(8, "Headphones")
        );
        List<Item> expected = Arrays.asList(
                new Item(8, "Headphones"),
                new Item(7, "Keyboard"),
                new Item(2, "Mouse")
        );
        Collections.sort(items, new ItemDescByName());
        assertEquals(items, expected);
    }
}