package ru.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до 3:");
            int matches = Integer.parseInt(input.nextLine());
            if (matches <= 3 & count >= matches) {
                turn = !turn;
                count -= matches;
                System.out.println("Осталось " + count + " спичек");
            } else {
                System.out.println("Ошибка: число не может быть больше 3 или спичек осталось меньше выбранного числа \nОсталось " + count + " спичек");
            }
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}
