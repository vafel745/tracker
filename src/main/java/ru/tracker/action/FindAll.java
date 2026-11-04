package ru.tracker.action;

import ru.tracker.input.Input;
import ru.tracker.Item;
import ru.tracker.output.Output;
import ru.tracker.Tracker;
import java.util.List;

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
        List<Item> items = tracker.findAll();
        output.println("=== Вывод всех заявок ===");
        if (items.isEmpty()) {
            output.println("Хранилище ещё не содержит заявок");
        } else {
            for (Item item : items) {
                output.println(item);
            }
        }
        return true;
    }
}
