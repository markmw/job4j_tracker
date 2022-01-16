package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ItemAscByName {
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item(7, "Keyboard"),
                new Item(2, "Mouse"),
                new Item(8, "Headphones"),
                new Item(1, "Phone")
        );
        System.out.println("До сортировки:");
        System.out.println(items);
        System.out.println("После сортировки по возрастанию:");
        Collections.sort(items);
        System.out.println(items);
        System.out.println("После сортировки по убыванию:");
        Collections.sort(items, new ItemDescByName());
        System.out.println(items);
    }
}
