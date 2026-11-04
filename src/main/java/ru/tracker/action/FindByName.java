package ru.tracker.action;

import ru.tracker.input.Input;
import ru.tracker.Item;
import ru.tracker.output.Output;
import ru.tracker.Tracker;
import java.util.List;

public class FindByName implements User {
    private final Output output;

    public FindByName(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Найти заявку по имени";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Поиск заявки(ок) по имени ===");
        String name = input.askStr("Введите имя заявки(ок) которую хотите найти: ");
        List<Item> items = tracker.findByName(name);
        if (!items.isEmpty()) {
            for (Item item : items) {
                output.println(item);
            }
        } else {
            output.println("Заявки(ок) с таким именем не существует");
        }
        return true;
    }
}
