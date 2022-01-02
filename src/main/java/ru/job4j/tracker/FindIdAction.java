package ru.job4j.tracker;

public class FindIdAction implements UserAction {
    @Override
    public String name() {
        return "Find item by id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("Find item by id...");
        int findId = input.askInt("Enter id: ");
        Item mark = tracker.findById(findId);
        if (mark != null) {
            System.out.println(mark);
        } else {
            System.out.println("Not found id: " + findId);
        }
        return true;
    }
}
