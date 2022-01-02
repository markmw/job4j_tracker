package ru.job4j.tracker;

public class FindIdAction implements UserAction {
    private final Output out;

    public FindIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("Find item by id...");
        int findId = input.askInt("Enter id: ");
        Item mark = tracker.findById(findId);
        if (mark != null) {
            out.println(mark);
        } else {
            out.println("Not found id: " + findId);
        }
        return true;
    }
}
