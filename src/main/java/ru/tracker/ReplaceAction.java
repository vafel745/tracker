package ru.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "Изменить заявку";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Изменение заявки ===");
        int idItem = input.askInt("Введите id заявки которую хотите заменить: ");
        String name = input.askStr("Напишите новое имя: ");
        Item item = new Item(name);
        if (!tracker.replace(idItem, item)) {
            System.out.println("Заявки с таким id не существует");
        } else {
            System.out.println("Изменённая заявка: " + item);
        }
        return true;
    }
}
