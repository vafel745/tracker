package ru.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "Найти заявку по имени";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Поиск заявки(ок) по id ===");
        String name = input.askStr("Введите имя заявки(ок) которую хотите найти: ");
        Item[] items = tracker.findByName(name);
        if (items.length != 0) {
            for (int i = 0; i < items.length; i++) {
                System.out.println(items[i]);
            }
        } else {
            System.out.println("Заявки(ок) с таким именем не существует");
        }
        return true;
    }
}
