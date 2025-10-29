package ru.oop;

public class Cat {

    private String food;
    private String name;

    public void show() {
        System.out.println(name);
        System.out.println(food);
    }

    public void eat(String meat) {
        food = meat;
    }

    public void giveNick(String nick) {
        name = nick;
    }

    public static void main(String[] args) {
        System.out.println("There are gav's food.");
        Cat gav = new Cat();
        gav.eat("kotleta");
        gav.giveNick("Cat1");
        gav.show();
        System.out.println("There are black's food.");
        Cat black = new Cat();
        black.eat("fish");
        black.giveNick("Cat2");
        black.show();
    }
}
