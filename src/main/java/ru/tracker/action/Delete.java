package ru.tracker.action;

import ru.tracker.input.Input;
import ru.tracker.output.Output;
import ru.tracker.Tracker;

public class Delete implements User {
    private final Output output;

    public Delete(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Удалить заявку";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Удаление заявки ===");
        int idItem = input.askInt("Введите id заявки которую хотите удалить: ");
        if (tracker.findById(idItem) == null) {
            output.println("Заявки с таким id не существует");
        } else {
            tracker.delete(idItem);
            output.println("Заявка удалена");
        }
        return true;
    }
}
