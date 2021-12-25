package ru.job4j.tracker.inheritance;

public class Engineer extends Profession {
    private String speciality;

    public Engineer(String name,
                    String surname,
                    String education,
                    String birthday,
                    String speciality)
    {
        super(name, surname, education, birthday);
        this.speciality = speciality;
    }

    public Engineer() {
    }

    public String getSpeciality() {
        return speciality;
    }
}
