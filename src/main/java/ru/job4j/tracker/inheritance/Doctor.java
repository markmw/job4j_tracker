package ru.job4j.tracker.inheritance;

public class Doctor extends Profession {
    private String direction;

    public Doctor(String name,
                  String surname,
                  String education,
                  String birthday,
                  String direction)
    {
        super(name, surname, education, birthday);
        this.direction = direction;
    }

    public Doctor() {
    }

    public String getDirection() {
        return direction;
    }
}
