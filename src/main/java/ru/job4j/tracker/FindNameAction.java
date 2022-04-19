package ru.job4j.tracker;

import java.util.List;

public class FindNameAction implements UserAction {
    private final Output out;

    public FindNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("Find items by name...");
        String moniker = input.askStr("Enter name: ");
        List<Item> queu = store.findByName(moniker);
        if (queu.size() > 0) {
            for (Item item : queu) {
                out.println(item);
            }
        } else {
            out.println("Not found name: " + moniker);
        }
        return true;
    }
}
