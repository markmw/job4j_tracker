package ru.job4j.tracker;

public class ValidateInput implements Input {
    private final Output out;
    private final Input in;

    public ValidateInput(Output out, Input in) {
        this.out = out;
        this.in = in;
    }

    public String askStr(String question) {
        return in.askStr(question);
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                String rsl = in.askStr(question);
                value = Integer.parseInt(rsl);
                invalid = false;
            } catch (NumberFormatException nfe) {
                out.println("Please enter correct data (Integer value)");
            }
        } while (invalid);
        return value;
    }
}
