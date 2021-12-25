package ru.job4j.tracker.inheritance;

public class Dentist extends Doctor {
    private boolean assistant;

    public Dentist(String name,
                   String surname,
                   String education,
                   String birthday,
                   String direction,
                   boolean assistant) {
        super(name, surname, education, birthday, direction);
        this.assistant = assistant;
    }

    public Dentist() {
    }

    public boolean getAssistan() {
        return assistant;
    }
}
