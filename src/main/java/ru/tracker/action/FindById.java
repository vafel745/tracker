package ru.tracker.action;

import ru.tracker.input.Input;
import ru.tracker.Item;
import ru.tracker.output.Output;
import ru.tracker.Tracker;

public class FindById implements User {
    private final Output output;

    public FindById(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Найти заявку по id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Поиск заявки по id ===");
        int idItem = input.askInt("Введите id заявки которую хотите найти: ");
        Item item = tracker.findById(idItem);
        if (item == null) {
            output.println("Заявки с таким id не существует");
        } else {
            output.println(item);
        }
        return true;
    }
}
