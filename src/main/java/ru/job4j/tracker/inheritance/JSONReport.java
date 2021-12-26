package ru.job4j.tracker.inheritance;

public class JSONReport extends TextReport {
    public String generate(String name, String body) {
        return "{" + System.lineSeparator()
                + String.format("\t\"name\" : \"%s\",", name) + System.lineSeparator()
                + String.format("\t\"body\" : \"%s\"", body) + System.lineSeparator()
                + "}";
    }
}
