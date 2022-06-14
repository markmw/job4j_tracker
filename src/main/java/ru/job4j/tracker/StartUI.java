package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Store store, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, store);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu:");
        for (int i = 0; i < actions.size(); i++) {
            out.println(i + ". " + actions.get(i).name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = List.of(
                new CreateAction(output),
                new EditAction(output),
                new DeleteAction(output),
                new ShowAction(output),
                new FindIdAction(output),
                new FindNameAction(output),
                new ExitAction(output)
        );
        new StartUI(output).init(input, tracker, actions);

        MemTracker tracker1 = new MemTracker();
        for (int i = 0; i < 100000; i++) {
            tracker1.add(new Item("asd" + i));
            tracker1.add(new Item("asdd" + i));
            tracker1.add(new Item("asddd" + i));
            tracker1.add(new Item("asdddd" + i));
            tracker1.add(new Item("asddddd" + i));
            tracker1.add(new Item("asdddddd" + i));
            tracker1.add(new Item("asddddddd" + i));
            tracker1.replace(i, new Item("asdasd "));
            tracker1.delete(i + 1);
            tracker1.findById(i + 3);
            tracker1.findAll();
        }
    }
}
