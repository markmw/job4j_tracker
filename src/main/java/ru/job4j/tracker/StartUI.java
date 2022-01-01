package ru.job4j.tracker;

public class StartUI {
    public static void createItem(Input input, Tracker tracker) {
        System.out.println("Add new Item...");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showItem(Input input, Tracker tracker) {
        System.out.println("Show all items...");
        Item[] all = tracker.findAll();
        if (all.length > 0) {
            for (Item item : all) {
                System.out.println(item);
            }
        } else {
            System.out.println("The store does not contain tickets yet");
        }
    }

    public static void editItem(Input input, Tracker tracker) {
        System.out.println("Edit item...");
        int id = input.askInt("Enter id: ");
        String forename = input.askStr("Enter name: ");
        Item point = new Item(forename);
        if (tracker.replace(id, point)) {
            System.out.println("Well done!");
        } else {
            System.out.println("Ops..try again");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("Delete item...");
        int rqid = input.askInt("Enter id: ");
        if (tracker.delete(rqid)) {
            System.out.println("Item deleted");
        } else {
            System.out.println("Delete failed");
        }
    }

    public static void findItemId(Input input, Tracker tracker) {
        System.out.println("Find item by id...");
        int findId = input.askInt("Enter id: ");
        Item mark = tracker.findById(findId);
        if (mark != null) {
            System.out.println(mark);
        } else {
            System.out.println("Not found id: " + findId);
        }
    }

    public static void findItemName(Input input, Tracker tracker) {
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
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showItem(input, tracker);
            } else if (select == 2) {
                StartUI.editItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findItemId(input, tracker);
            } else if (select == 5) {
                    StartUI.findItemName(input, tracker);
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
