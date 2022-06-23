package ru.job4j.function;

import java.util.*;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        List<String> list = Arrays.asList(
                "one", "two", "three", "four", "five", "six", "seven"
        );
        BiConsumer<Integer, String> biCon = (i, s) -> map.put(i, s);
        int i = 1;
        for (String el : list) {
            biCon.accept(i, el);
            i++;
        }
        System.out.println(map);

        BiPredicate<Integer, String> biPred = ((number, s) -> number % 2 == 0 || s.length() == 4);
        for (Integer number : map.keySet()) {
            System.out.println("key: " + number + " value: " + biPred.test(number, map.get(number)));
        }

        Supplier<List<String>> sup = () -> new ArrayList<>(map.values());
        System.out.println(sup.get());

        Consumer<String> con = (s) -> System.out.println(s);
        Function<String, String> func = (strings) -> strings.toUpperCase();
        for (String s : map.values()) {
            con.accept(func.apply(s));
        }
    }
}
