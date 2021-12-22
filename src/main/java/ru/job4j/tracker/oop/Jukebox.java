package ru.job4j.tracker.oop;

public class Jukebox {
    public void music(int postion) {
        if (postion == 1) {
            System.out.println("Пусть бегут неуклюже");
        } else if (postion == 2) {
            System.out.println("Спокойной ночи");
        } else {
            System.out.println("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        Jukebox petya = new Jukebox();
        petya.music(1);
        petya.music(2);
        petya.music(0);
        petya.music(3);
    }
}
