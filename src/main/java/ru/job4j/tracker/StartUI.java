package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            int select = Integer.parseInt(input.askStr("Select: "));
            if (select == 0) {
                System.out.println("Add new Item...");
                String name = input.askStr("Enter name: ");
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
                int id = Integer.parseInt(input.askStr("Enter id: "));
                String forename = input.askStr("Enter name: ");
                Item point = new Item(forename);
                if (tracker.replace(id, point)) {
                    System.out.println("Well done!");
                } else {
                    System.out.println("Ops..try again");
                }
            } else if (select == 3) {
                System.out.println("Delete item...");
                int rqid = Integer.parseInt(input.askStr("Enter id: "));
                if (tracker.delete(rqid)) {
                    System.out.println("Item deleted");
                } else {
                    System.out.println("Delete failed");
                }
            } else if (select == 4) {
                System.out.println("Find item by id...");
                int findId = Integer.parseInt(input.askStr("Enter id: "));
                Item mark = tracker.findById(findId);
                if (mark != null) {
                    System.out.println(mark);
                } else {
                    System.out.println("Not found id: " + findId);
                }
            } else if (select == 5) {
                    System.out.println("Find items by name...");
                    String moniker = input.askStr("Enter name: ");
                    Item[] queu = tracker.findByName(moniker);
                    if (queu.length > 0) {
                        for (Item item : queu) {
                            System.out.println(queu);
                        }
                    } else {
                        System.out.println("Not found name: " + moniker);
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
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
