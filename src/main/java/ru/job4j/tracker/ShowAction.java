package ru.job4j.tracker;

import java.util.List;

public class ShowAction implements UserAction {
    private final Output out;

    public ShowAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("Show all items...");
        List<Item> all = store.findAll();
        if (all.size() > 0) {
            for (Item item : all) {
                out.println(item);
            }
        } else {
            out.println("The store does not contain tickets yet");
        }
        return true;
    }
}
