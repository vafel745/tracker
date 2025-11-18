package ru.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int z) {
        return x - z;
    }

    public int divide(int b) {
        return b / x;
    }

    public int sumAllOperation(int res) {
        return sum(res) + multiply(res) + minus(res) + divide(res);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int resSum = sum(10);
        System.out.println(resSum);
        System.out.println(calculator.multiply(1));
        int resMinus = minus(3);
        System.out.println(resMinus);
        System.out.println(calculator.divide(5));
        System.out.println(calculator.sumAllOperation(3));
    }
}
