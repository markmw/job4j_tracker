package ru.job4j.tracker.collection;

import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String value : origin) {
            check.add(value);
        }
        for (String value : text) {
            if (!check.contains(value)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
