package ru.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Тип ошибки: " + active);
        System.out.println("Статус ошибки: " + status);
        System.out.println("Сообщение о ошибке: " + message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        Error error1 = new Error(true, 1, "ArrayIndexOutOfBoundsException");
        Error error2 = new Error(true, 2, "ArithmeticException");
        error.printInfo();
        error1.printInfo();
        error2.printInfo();
    }
}
