package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball ball = new Ball();
        Hare hare = new Hare();
        Wolf wolf = new Wolf();
        Fox fox = new Fox();
        System.out.println("Встретил заяц колобка:");
        hare.tryEat(ball);
        System.out.println("Встретил волк колобка:");
        wolf.tryEat(ball);
        System.out.println("Встретила лиса колобка:");
        fox.tryEat(ball);
    }
}
