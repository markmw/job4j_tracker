package ru.job4j.inheritance;

public class Builder extends Engineer {
    private double weight;

    public Builder(String name,
                   String surname,
                   String education,
                   String birthday,
                   String speciality,
                   double weight) {
        super(name, surname, education, birthday, speciality);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
}
