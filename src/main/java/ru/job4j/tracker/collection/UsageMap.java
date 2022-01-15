package ru.job4j.tracker.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("addy@yandex.ru", "Addy Bay");
        map.put("someone@yandex.ru", "Someone Guy");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " " + value);
        }
    }
}
