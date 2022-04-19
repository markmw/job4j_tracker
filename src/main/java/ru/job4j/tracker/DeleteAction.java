package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("Delete item...");
        int rqid = input.askInt("Enter id: ");
        if (store.delete(rqid)) {
            out.println("Item deleted");
        } else {
            out.println("Delete failed");
        }
        return true;
    }
}
