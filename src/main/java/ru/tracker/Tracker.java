package ru.tracker;

import java.util.Arrays;
import java.util.Objects;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[size];
        int sizeName = 0;
        for (int i = 0; i < size; i++) {
            Item item = items[i];
            if (Objects.equals(item.getName(), key)) {
                rsl[sizeName++] = items[i];
            }
        }
        return Arrays.copyOf(rsl, sizeName);
    }

    private int indexOf(int id) {
        for (int i = 0; i < size; i++) {
            Item item = items[i];
            if (item.getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        if (index != -1) {
            return items[index];
        }
        return null;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items[index] = item;
            return true;
        }
        return false;
    }

    public void delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
            items[size - 1] = null;
            size--;
        }
    }
}
