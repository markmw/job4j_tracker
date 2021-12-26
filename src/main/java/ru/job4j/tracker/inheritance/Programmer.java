package ru.job4j.tracker.inheritance;

public class Programmer extends Engineer {
    private String lang;

    public Programmer(String name,
                      String surname,
                      String education,
                      String birthday,
                      String speciality,
                      String lang) {
        super(name, surname, education, birthday, speciality);
        this.lang = lang;
    }

    public String getLang() {
        return lang;
    }
}
