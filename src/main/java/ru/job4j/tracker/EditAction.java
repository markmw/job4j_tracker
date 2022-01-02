package ru.job4j.tracker;

public class EditAction implements UserAction {
    @Override
    public String name() {
        return "Edit Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("Edit item...");
        int id = input.askInt("Enter id: ");
        String forename = input.askStr("Enter name: ");
        Item point = new Item(forename);
        if (tracker.replace(id, point)) {
            System.out.println("Well done!");
        } else {
            System.out.println("Ops..try again");
        }
        return true;
    }
}
