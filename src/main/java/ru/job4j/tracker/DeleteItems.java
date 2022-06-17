package ru.job4j.tracker;

public class DeleteItems implements UserAction {
    private final Output out;

    public DeleteItems(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "---Delete some items---";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("---Delete items---");
        int id = input.askInt("Enter id: ");
        int amount = input.askInt("Enter amount: ");
        for (int i = 0; i < amount; i++) {
            store.delete(id);
        }
        return true;
    }
}
