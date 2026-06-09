package ru.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Удалить заявку";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Удаление заявки ===");
        int idItem = input.askInt("Введите id заявки которую хотите удалить: ");
        if (tracker.findById(idItem) == null) {
            System.out.println("Заявки с таким id не существует");
        } else {
            tracker.delete(idItem);
            System.out.println("Заявка удалена");
        }
        return true;
    }
}
