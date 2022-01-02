package ru.job4j.tracker;

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
    public boolean execute(Input input, Tracker tracker) {
        out.println("Show all items...");
        Item[] all = tracker.findAll();
        if (all.length > 0) {
            for (Item item : all) {
                out.println(item);
            }
        } else {
            out.println("The store does not contain tickets yet");
        }
        return true;
    }
}
