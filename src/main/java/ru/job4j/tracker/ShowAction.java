package ru.job4j.tracker;

public class ShowAction implements UserAction {
    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("Show all items...");
        Item[] all = tracker.findAll();
        if (all.length > 0) {
            for (Item item : all) {
                System.out.println(item);
            }
        } else {
            System.out.println("The store does not contain tickets yet");
        }
        return true;
    }
}
