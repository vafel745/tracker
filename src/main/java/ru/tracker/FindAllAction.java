package ru.tracker;

public class FindAllAction implements UserAction {
    private final Output output;

    public FindAllAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Показать все заявки";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
        output.println("=== Вывод всех заявок ===");
        if (items.length == 0) {
            output.println("Хранилище ещё не содержит заявок");
        } else {
            for (int i = 0; i < items.length; i++) {
                output.println(items[i]);
            }
        }
        return true;
    }
}
