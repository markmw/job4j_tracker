package ru.job4j.tracker;

public class CreateAction implements UserAction {
    private final Output out;

    public CreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add new Item";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("Add new Item...");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        store.add(item);
        return true;
    }
}
