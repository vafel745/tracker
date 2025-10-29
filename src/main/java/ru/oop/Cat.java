package ru.oop;

public class Cat {

    private String food;
    private String name;

    public void show() {
        System.out.println("Имя котика " + name);
        System.out.println(name + " ел " + food);
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
