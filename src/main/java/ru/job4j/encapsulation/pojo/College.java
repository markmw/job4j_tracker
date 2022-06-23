package ru.job4j.encapsulation.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Addy");
        student.setSurname("Baitorynov");
        student.setGroup("2A");
        student.setCreated(new Date());
        System.out.println(student.getName() + " "
                + student.getSurname() + " from "
                + student.getGroup() + " at "
                + student.getCreated());
    }
}
