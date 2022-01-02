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
    public boolean execute(Input input, Tracker tracker) {
        out.println("Delete item...");
        int rqid = input.askInt("Enter id: ");
        if (tracker.delete(rqid)) {
            out.println("Item deleted");
        } else {
            out.println("Delete failed");
        }
        return true;
    }
}
