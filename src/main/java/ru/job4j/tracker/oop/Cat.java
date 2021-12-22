package ru.job4j.tracker.oop;

public class Cat {
    private String food;
    private String name;

    public void giveNick(String nick) {
        this.name = nick;
    }

    public void show() {
        System.out.println(this.name + " " + this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public static void main(String[] args) {
        System.out.println("There are gav's food.");
        Cat gav = new Cat();
        gav.giveNick("Vasya");
        gav.eat("kotleta");
        gav.show();
        System.out.println("There are black's food.");
        Cat black = new Cat();
        black.giveNick("Popa");
        black.eat("fish");
        black.show();
    }
}