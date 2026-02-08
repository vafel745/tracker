package ru.pojo;

public class Library {
    public static void main(String[] args) {
        Book bookOne = new Book("first", 10);
        Book bookTwo = new Book("second", 20);
        Book bookThree = new Book("thirst", 30);
        Book bookFour = new Book("Clean code", 40);
        Book temp = new Book("", 0);
        Book[] books = new Book[5];
        books[0] = bookOne;
        books[1] = bookTwo;
        books[2] = bookThree;
        books[3] = bookFour;
        books[4] = temp;
        for (int i = 0; i < books.length - 1; i++) {
            Book allBooks = books[i];
            System.out.println(allBooks.getName() + " - " + allBooks.getNumberOfPages());
        }
        System.out.println("\nSwitch booksOne and booksThree\n");
        temp = books[3];
        books[3] = books[0];
        books[0] = temp;
        for (int i = 0; i < books.length - 1; i++) {
            Book allBooks = books[i];
            System.out.println(allBooks.getName() + " - " + allBooks.getNumberOfPages());
        }
        System.out.println("\nBooks with the name Clean code only\n");
        for (int i = 0; i < books.length - 1; i++) {
            Book allBooks = books[i];
            if (allBooks.getName() == "Clean code") {
                System.out.println(allBooks.getName() + " - " + allBooks.getNumberOfPages());
            }
        }
    }
}
