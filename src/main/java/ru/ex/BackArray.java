package ru.ex;

public class BackArray {
    public String[] turn(String[] names) {
        int middle = names.length / 2;
        int lengthArray = names.length - 1;
        for (int index = 0; index < middle; index++) {
            String temp = names[index];
            names[index] = names[lengthArray - index];
            names[lengthArray - index] = temp;
        }
        return names;
    }
}
