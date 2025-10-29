package ru.oop;

public class Ball {
    public void tryRun(boolean condition) {
        String result = condition ? "Колобка съели" : "Колобок сбежал";
        System.out.println(result);
    }
}
