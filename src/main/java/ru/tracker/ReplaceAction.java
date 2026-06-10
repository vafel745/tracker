package ru.tracker;

public class ReplaceAction implements UserAction {
    private final Output output;

    public ReplaceAction(Output output) {
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
