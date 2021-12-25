package ru.job4j.tracker.inheritance;

public class Surgeon extends Doctor {
    private int experience;

    public Surgeon(String name,
                   String surname,
                   String education,
                   String birthday,
                   String direction,
                   int experience) {
        super(name, surname, education, birthday, direction);
        this.experience = experience;
    }

    public Surgeon() {
    }

    public int getExperience() {
        return experience;
    }
}
