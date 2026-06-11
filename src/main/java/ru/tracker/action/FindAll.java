package ru.tracker.action;

import ru.tracker.input.Input;
import ru.tracker.Item;
import ru.tracker.output.Output;
import ru.tracker.Tracker;

public class FindAll implements User {
    private final Output output;

    public FindAll(Output output) {
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
