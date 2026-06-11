package ru.ex;

import java.util.Objects;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        int lengthArray = value.length - 1;
        for (int i = 0; i <= lengthArray; i++) {
            if (Objects.equals(value[i], key)) {
                result = i;
            } else if (i == lengthArray) {
                throw new ElementNotFoundException("Элемента не существует");
            }
        }
        return result;
    }

    public static void main(String[] args) {
        try {
            indexOf(new String[]{"banana", "apple", "tomato"}, "apples");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
