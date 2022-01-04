package ru.job4j.tracker.ooa;

public final class Airbus extends Aircraft {
    private final int countEngine = 2;
    private String name;

    public Airbus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void printModel() {
        System.out.println("Модель самолета: " + name);
    }

    public void printCountEngine() {
        if ("A380".equals(name)) {
            int engine = 4;
            System.out.println("Количество двигателей равно: " + engine);
        } else {
            System.out.println("Количество двигателей равно: " + countEngine);
        }
    }

    @Override
    public String toString() {
        return "Airbus{"
                + "name='" + name + '\''
                + '}';
    }
}
