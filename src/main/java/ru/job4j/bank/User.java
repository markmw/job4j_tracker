package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель пользователя банка
 * @author adletbaitorynov
 * @version 1.0
 */
public class User {
    /**
     * поле passport содержит номер паспорта пользователя
     */
    private String passport;
    /**
     * поле username содержит ФИО пользователя
     */
    private String username;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Обобщенный переопределенный метод equals
     * @param o обьект
     * @return возвращает булево значение - true или false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Обобщенный переопределенный метод hashCode
     * @return возвращает целочисленное значение(хэш) поля паспорт
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
