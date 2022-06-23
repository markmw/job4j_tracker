package ru.job4j.encapsulation.pojo;

public class Library {
    public static void main(String[] args) {
        Book java = new Book("Java 8 - Original Management", 5);
        Book cook = new Book("First Cooking", 2);
        Book code = new Book("Clean code", 7);
        Book earth = new Book("This Earth", 4);
        Book[] books = new Book[4];
        books[0] = java;
        books[1] = cook;
        books[2] = code;
        books[3] = earth;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " - " + book.getCount());
        }
        System.out.println("Swap earth to java:");
        Book temp = books[3];
        books[3] = books[0];
        books[0] = temp;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " - " + book.getCount());
        }
        System.out.println("Shown only book.name - Clean code:");
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            if ("Clean code".equals(book.getName())) {
                System.out.println(book.getName() + " - " + book.getCount());
            }
        }
    }
}
