package ru.job4j.tracker;

public class EditAction implements UserAction {
    private final Output out;

    public EditAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit Item";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("Edit item...");
        int id = input.askInt("Enter id: ");
        String forename = input.askStr("Enter name: ");
        Item point = new Item(forename);
        if (store.replace(id, point)) {
            out.println("Well done!");
        } else {
            out.println("Ops..try again");
        }
        return true;
    }
}
