package ru.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {
    @Test
    void whenCreateItem() {
        Output output = new MockOutput();
        Input input = new MockInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        Item created = tracker.findAll()[0];
        assertThat(created.getName()).isEqualTo("Item name");
        assertThat(output.toString()).isEqualTo(
                "Меню:" + System.lineSeparator()
                        + "0. Добавить новую заявку" + System.lineSeparator()
                        + "1. Завершить программу" + System.lineSeparator()
                        + "=== Создание новой заявки ===" + System.lineSeparator()
                        + "Добавленная заявка: " + created + System.lineSeparator()
                        + "Меню:" + System.lineSeparator()
                        + "0. Добавить новую заявку" + System.lineSeparator()
                        + "1. Завершить программу" + System.lineSeparator()
                        + "=== Завершение программы ===" + System.lineSeparator()
        );
    }

    @Test
    void whenReplaceItem() {
        Output output = new MockOutput();
        Input input = new MockInput(
                new String[] {
                        "0", "1", "Item edited",
                        "1"
                }
        );
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        UserAction[] actions = {
                new ReplaceAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        Item edited = tracker.findById(item.getId());
        assertThat(edited.getName()).isEqualTo("Item edited");
        assertThat(output.toString()).isEqualTo(
                "Меню:" + System.lineSeparator()
                        + "0. Изменить заявку" + System.lineSeparator()
                        + "1. Завершить программу" + System.lineSeparator()
                        + "=== Изменение заявки ===" + System.lineSeparator()
                        + "Изменённая заявка: " + edited + System.lineSeparator()
                        + "Меню:" + System.lineSeparator()
                        + "0. Изменить заявку" + System.lineSeparator()
                        + "1. Завершить программу" + System.lineSeparator()
                        + "=== Завершение программы ===" + System.lineSeparator()
        );
    }

    @Test
    void whenDeleteItem() {
        Output output = new MockOutput();
        Input input = new MockInput(
                new String[] {
                        "0", "1",
                        "1"
                }
        );
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        UserAction[] actions = {
                new DeleteAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        Item deleted = tracker.findById(item.getId());
        assertThat(deleted).isNull();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + System.lineSeparator()
                + "0. Удалить заявку" + System.lineSeparator()
                + "1. Завершить программу" + System.lineSeparator()
                + "=== Удаление заявки ===" + System.lineSeparator()
                + "Заявка удалена" + System.lineSeparator()
                + "Меню:" + System.lineSeparator()
                + "0. Удалить заявку" + System.lineSeparator()
                + "1. Завершить программу" + System.lineSeparator()
                + "=== Завершение программы ===" + System.lineSeparator()
        );
    }

    @Test
    void whenExit() {
        Output output = new MockOutput();
        Input input = new MockInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                "Меню:" + System.lineSeparator()
                        + "0. Завершить программу" + System.lineSeparator()
                        + "=== Завершение программы ===" + System.lineSeparator()
        );
    }
}
