package ru.job4j.tracker;

public class CreateItems implements UserAction {
    private final Output out;

    public CreateItems(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "---Create some items---";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("---Create items---");
        String name = input.askStr("Enter name: ");
        int amount = input.askInt("Enter amount: ");
        Item item = new Item(name);
        for (int i = 0; i < amount; i++) {
            store.add(item);
        }
        return true;
    }
}
