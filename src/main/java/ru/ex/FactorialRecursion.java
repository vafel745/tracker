package ru.ex;

public class FactorialRecursion {
    public static int calc(int n) {
        if (n == 0) {
            return n;
        }
        System.out.println(n);
        return calc(n - 1) * n;
    }

    public static void main(String[] args) {
        int result = calc(5);
        System.out.println(result);
    }
}
