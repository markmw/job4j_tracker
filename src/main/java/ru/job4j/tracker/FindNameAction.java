package ru.job4j.tracker;

public class FindNameAction implements UserAction {
    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
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
        return true;
    }
}
