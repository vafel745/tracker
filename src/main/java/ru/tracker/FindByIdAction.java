package ru.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "Найти заявку по id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Поиск заявки по id ===");
        int idItem = input.askInt("Введите id заявки которую хотите найти: ");
        Item item = tracker.findById(idItem);
        if (item == null) {
            System.out.println("Заявки с таким id не существует");
        } else {
            System.out.println(item);
        }
        return true;
    }
}
