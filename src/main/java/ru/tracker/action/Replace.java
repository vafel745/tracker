package ru.tracker.action;

import ru.tracker.input.Input;
import ru.tracker.Item;
import ru.tracker.output.Output;
import ru.tracker.Tracker;

public class Replace implements User {
    private final Output output;

    public Replace(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Изменить заявку";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Изменение заявки ===");
        int idItem = input.askInt("Введите id заявки которую хотите заменить: ");
        String name = input.askStr("Напишите новое имя: ");
        Item item = new Item(name);
        if (!tracker.replace(idItem, item)) {
            output.println("Заявки с таким id не существует");
        } else {
            output.println("Изменённая заявка: " + item);
        }
        return true;
    }
}
