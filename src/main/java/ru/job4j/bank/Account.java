package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель банковского счета
 * @author Adlet Baitorynov
 * @version 1.0
 */
public class Account {
    /**
     * поле requisite содержит реквизиты счета
     */
    private String requisite;
    /**
     * поле balance содержит остаток на счете
     */
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Обобщенный переопределенный метод equals
     * @param o обьект
     * @return возвращает булево значение
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Обобщенный переопределенный метод hashCode
     * @return возвращает целочисленное значение(хэш) поля requisite
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
