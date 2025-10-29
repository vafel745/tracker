package ru.oop;

public class Cat {

    private String food;
    private String name;

    public void show() {
        System.out.println("Кота зовут " + name);
        System.out.println("Любимая еда " + name + "а это " + food);
    }

    public void eat(String meat) {
        food = meat;
    }

    public void giveNick(String nick) {
        name = nick;
    }

    public static void main(String[] args) {
        Cat gav = new Cat();
        gav.eat("котлета");
        gav.giveNick("Бобик");
        gav.show();
        Cat black = new Cat();
        black.eat("рыба");
        black.giveNick("Блобик");
        black.show();
    }
}
