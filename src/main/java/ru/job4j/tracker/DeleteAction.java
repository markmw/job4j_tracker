package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("Delete item...");
        int rqid = input.askInt("Enter id: ");
        if (tracker.delete(rqid)) {
            System.out.println("Item deleted");
        } else {
            System.out.println("Delete failed");
        }
        return true;
    }
}
