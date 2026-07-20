package ru.tracker;

import org.junit.jupiter.api.Test;
import ru.tracker.action.*;
import ru.tracker.input.Input;
import ru.tracker.input.MockInput;
import ru.tracker.output.MockOutput;
import ru.tracker.output.Output;

import static org.assertj.core.api.Assertions.*;

class StartUITest {
    @Test
    void whenCreateItem() {
        Output output = new MockOutput();
        Input input = new MockInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        User[] actions = {
                new Create(output),
                new Exit(output)
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
                new String[]{
                        "0", "1", "Item edited",
                        "1"
                }
        );
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        User[] actions = {
                new Replace(output),
                new Exit(output)
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
                new String[]{
                        "0", "1",
                        "1"
                }
        );
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        User[] actions = {
                new Delete(output),
                new Exit(output)
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
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        User[] actions = {
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                "Меню:" + System.lineSeparator()
                        + "0. Завершить программу" + System.lineSeparator()
                        + "=== Завершение программы ===" + System.lineSeparator()
        );
    }

    @Test
    void whenFindAllItemsTestOutputIsSuccessfully() {
        Output output = new MockOutput();
        String nameItemOne = "item";
        String nameItemTwo = "item two";
        Input input = new MockInput(
                new String[]{
                        "0",
                        "1"
                }
        );
        Tracker tracker = new Tracker();
        Item itemOne = new Item(nameItemOne);
        tracker.add(itemOne);
        Item itemTwo = new Item(nameItemTwo);
        tracker.add(itemTwo);
        User[] actions = {
                new FindAll(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать все заявки" + ln
                        + "1. Завершить программу" + ln
                        + "=== Вывод всех заявок ===" + ln
                        + itemOne + ln
                        + itemTwo + ln
                        + "Меню:" + ln
                        + "0. Показать все заявки" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindAllItemsTestOutputIsNotSuccessful() {
        Output output = new MockOutput();
        Input input = new MockInput(
                new String[]{
                        "0",
                        "1"
                }
        );
        Tracker tracker = new Tracker();
        User[] actions = {
                new FindAll(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать все заявки" + ln
                        + "1. Завершить программу" + ln
                        + "=== Вывод всех заявок ===" + ln
                        + "Хранилище ещё не содержит заявок" + ln
                        + "Меню:" + ln
                        + "0. Показать все заявки" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindByNameItemTestOutputIsSuccessfully() {
        Output output = new MockOutput();
        String nameItemOne = "item";
        String nameItemTwo = "item two";
        Input input = new MockInput(
                new String[]{
                        "0", nameItemOne,
                        "1"
                }
        );
        Tracker tracker = new Tracker();
        Item itemOne = new Item(nameItemOne);
        tracker.add(itemOne);
        Item itemTwo = new Item(nameItemTwo);
        tracker.add(itemTwo);
        User[] actions = {
                new FindByName(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Найти заявку по имени" + ln
                        + "1. Завершить программу" + ln
                        + "=== Поиск заявки(ок) по имени ===" + ln
                        + itemOne + ln
                        + "Меню:" + ln
                        + "0. Найти заявку по имени" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindByNameItemTestOutputIsNotSuccessful() {
        Output output = new MockOutput();
        String nameItemOne = "item";
        String nameItemTwo = "item two";
        Input input = new MockInput(
                new String[]{
                        "0", "apple",
                        "1"
                }
        );
        Tracker tracker = new Tracker();
        Item itemOne = new Item(nameItemOne);
        tracker.add(itemOne);
        Item itemTwo = new Item(nameItemTwo);
        tracker.add(itemTwo);
        User[] actions = {
                new FindByName(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Найти заявку по имени" + ln
                        + "1. Завершить программу" + ln
                        + "=== Поиск заявки(ок) по имени ===" + ln
                        + "Заявки(ок) с таким именем не существует" + ln
                        + "Меню:" + ln
                        + "0. Найти заявку по имени" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindByIdItemTestOutputIsSuccessfully() {
        Output output = new MockOutput();
        String nameItemOne = "item";
        String nameItemTwo = "item two";
        Input input = new MockInput(
                new String[]{
                        "0", "1",
                        "1"
                }
        );
        Tracker tracker = new Tracker();
        Item itemOne = new Item(nameItemOne);
        tracker.add(itemOne);
        Item itemTwo = new Item(nameItemTwo);
        tracker.add(itemTwo);
        User[] actions = {
                new FindById(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Найти заявку по id" + ln
                        + "1. Завершить программу" + ln
                        + "=== Поиск заявки по id ===" + ln
                        + itemOne + ln
                        + "Меню:" + ln
                        + "0. Найти заявку по id" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindByIdItemTestOutputIsNotSuccessful() {
        Output output = new MockOutput();
        String nameItemOne = "item";
        String nameItemTwo = "item two";
        Input input = new MockInput(
                new String[]{
                        "0", "3",
                        "1"
                }
        );
        Tracker tracker = new Tracker();
        Item itemOne = new Item(nameItemOne);
        tracker.add(itemOne);
        Item itemTwo = new Item(nameItemTwo);
        tracker.add(itemTwo);
        User[] actions = {
                new FindById(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Найти заявку по id" + ln
                        + "1. Завершить программу" + ln
                        + "=== Поиск заявки по id ===" + ln
                        + "Заявки с таким id не существует" + ln
                        + "Меню:" + ln
                        + "0. Найти заявку по id" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenInvalidExit() {
        Output output = new MockOutput();
        Input input = new MockInput(
                new String[]{
                        "7",
                        "0",
                        "1"
                }
        );
        Tracker tracker = new Tracker();
        User[] actions = {
                new FindAll(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать все заявки" + ln
                        + "1. Завершить программу" + ln
                        + "Неверный ввод, вы можете выбрать: 0 .. 1" + ln
                        + "Меню:" + ln
                        + "0. Показать все заявки" + ln
                        + "1. Завершить программу" + ln
                        + "=== Вывод всех заявок ===" + ln
                        + "Хранилище ещё не содержит заявок" + ln
                        + "Меню:" + ln
                        + "0. Показать все заявки" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }
}
