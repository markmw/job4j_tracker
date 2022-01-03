package ru.job4j.tracker;

public class ValidateInput implements Input {
    private final Input input;

    public ValidateInput(Input input) {
        this.input = input;
    }

    @Override
    public String askStr(String question) {
        return input.askStr(question);
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = input.askInt(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter correct data again.");
            }
        } while (invalid);
        return value;
    }

    @Override
    public int askInt(String question, int max) {
        boolean invalid = false;
        int value = -1;
        do {
            try {
                value = input.askInt(question, max);
                invalid = false;
            } catch (IllegalStateException ise) {
                System.out.println("Please select key menu");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter correct data again");
            }
        } while (invalid);
        return value;
    }
}
