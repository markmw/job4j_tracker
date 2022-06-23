package ru.job4j.inheritance;

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

    public boolean getAssistan() {
        return assistant;
    }
}
