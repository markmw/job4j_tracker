package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            System.out.print("Select: ");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("Add new Item...");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("Show all items...");
                Item[] all = tracker.findAll();
                if (all.length > 0) {
                    for (Item item : all) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("The store does not contain tickets yet");
                }
            } else if (select == 2) {
                System.out.println("Edit item...");
                System.out.print("Enter id: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter name: ");
                String forename = scanner.nextLine();
                Item point = new Item(forename);
                tracker.replace(id, point);
                if (tracker.replace(id, point)) {
                    System.out.println("Well done!");
                } else {
                    System.out.println("Ops..try again");
                }
            } else if (select == 3) {
                System.out.println("Delete item...");
                System.out.print("Enter id: ");
                int rqid = Integer.parseInt(scanner.nextLine());
                boolean delete = tracker.delete(rqid);
                if (delete) {
                    System.out.println("Item deleted");
                } else {
                    System.out.println("Delete failed");
                }
            } else if (select == 4) {
                System.out.println("Find item by id...");
                System.out.println("Enter id: ");
                int findId = Integer.parseInt(scanner.nextLine());
                Item mark = tracker.findById(findId);
                if (mark != null) {
                    System.out.println(mark);
                } else {
                    System.out.println("Not found: " + mark);
                }
            } else if (select == 5) {
                    System.out.println("Find items by name...");
                    System.out.println("Enter name: ");
                    String moniker = scanner.nextLine();
                    Item[] queu = tracker.findByName(moniker);
                    if (queu.length > 0) {
                        for (Item item : queu) {
                        System.out.println(queu);
                        }
                    } else {
                        System.out.println("Not found: " + moniker);
                    }
            } else if (select == 6) {
                run = false;
                System.out.println("Exit Program");
            }
        }
    }

    private void showMenu() {
        String[] menu = {
                "Add new Item", "Show all items", "Edit item",
                "Delete item", "Find item by id", "Find items by name",
                "Exit Program"
        };
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
