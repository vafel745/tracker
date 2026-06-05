package ru.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            System.out.print("Выбрать: ");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Создание новой заявки ===");
                System.out.print("Введите имя: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Добавленная заявка: " + item);
            } else if (select == 1) {
                Item[] items = tracker.findAll();
                System.out.println("=== Вывод всех заявок ===");
                if (items.length == 0) {
                    System.out.println("Хранилище ещё не содержит заявок");
                } else {
                    for (int i = 0; i < items.length; i++) {
                        System.out.println(items[i]);
                    }
                }
            } else if (select == 2) {
                System.out.println("=== Изменение заявки ===\nВведите id заявки которую хотите заменить");
                int idItem = Integer.parseInt(scanner.nextLine());
                System.out.println("Напишите новое имя");
                String name = scanner.nextLine();
                Item item = new Item(name);
                if (!tracker.replace(idItem, item)) {
                    System.out.println("Заявки с таким id не существует");
                } else {
                    System.out.println("Изменённая заявка: " + item);
                }
            } else if (select == 6) {
                run = false;
            }
        }
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
