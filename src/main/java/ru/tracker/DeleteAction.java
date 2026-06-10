package ru.tracker;

public class DeleteAction implements UserAction {
    private final Output output;

    public DeleteAction(Output output) {
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
