package ru.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        String msg;
        while (run) {
            showMenu();
            msg = "Выбрать: ";
            int select = input.askInt(msg);
            if (select == 0) {
                createItem(input, tracker);
            } else if (select == 1) {
                findAllItems(tracker);
            } else if (select == 2) {
                replaceItem(input, tracker);
            } else if (select == 3) {
                deleteItem(input, tracker);
            } else if (select == 4) {
                findItemById(input, tracker);
            } else if (select == 5) {
                findItemByName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
        String msg;
        System.out.println("=== Поиск заявки(ок) по id ===");
        msg = "Введите имя заявки(ок) которую хотите найти: ";
        String name = input.askStr(msg);
        Item[] items = tracker.findByName(name);
        if (items.length != 0) {
            for (int i = 0; i < items.length; i++) {
                System.out.println(items[i]);
            }
        } else {
            System.out.println("Заявки(ок) с таким именем нету");
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        String msg;
        System.out.println("=== Поиск заявки по id ===");
        msg = "Введите id заявки которую хотите найти: ";
        int idItem = input.askInt(msg);
        Item item = tracker.findById(idItem);
        if (item == null) {
            System.out.println("Заявки с таким id не существует");
        } else {
            System.out.println(item);
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        String msg;
        System.out.println("=== Удаление заявки ===");
        msg = "Введите id заявки которую хотите удалить: ";
        int idItem = input.askInt(msg);
        if (tracker.findById(idItem) == null) {
            System.out.println("Заявки с таким id не существует");
        } else {
            tracker.delete(idItem);
            System.out.println("Заявка удалена");
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        String msg;
        System.out.println("=== Изменение заявки ===");
        msg = "Введите id заявки которую хотите заменить: ";
        int idItem = input.askInt(msg);
        msg = "Напишите новое имя: ";
        String name = input.askStr(msg);
        Item item = new Item(name);
        if (!tracker.replace(idItem, item)) {
            System.out.println("Заявки с таким id не существует");
        } else {
            System.out.println("Изменённая заявка: " + item);
        }
    }

    public static void findAllItems(Tracker tracker) {
        Item[] items = tracker.findAll();
        System.out.println("=== Вывод всех заявок ===");
        if (items.length == 0) {
            System.out.println("Хранилище ещё не содержит заявок");
        } else {
            for (int i = 0; i < items.length; i++) {
                System.out.println(items[i]);
            }
        }
    }

    public static void createItem(Input input, Tracker tracker) {
        String msg;
        System.out.println("=== Создание новой заявки ===");
        msg = "Введите имя: ";
        String name = input.askStr(msg);
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Добавленная заявка: " + item);
    }

    private void showMenu() {
        String[] menu = {
                "Добавить новую заявку", "Показать все заявки", "Изменить заявку",
                "Удалить заявку", "Показать заявку по id", "Показать заявки по имени", "Завершить программу"
        };
        System.out.println("Меню:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
