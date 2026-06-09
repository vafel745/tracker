package ru.tracker;

public class FindAllAction implements UserAction {
    @Override
    public String name() {
        return "Показать все заявки";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
        System.out.println("=== Вывод всех заявок ===");
        if (items.length == 0) {
            System.out.println("Хранилище ещё не содержит заявок");
        } else {
            for (int i = 0; i < items.length; i++) {
                System.out.println(items[i]);
            }
        }
        return true;
    }
}
