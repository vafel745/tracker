package ru.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(size++, item);
        return item;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        for (Item item : items) {
            if (Objects.equals(item.getName(), key)) {
                rsl.add(item);
            }
        }
        return rsl;
    }

    private int indexOf(int id) {
        for (int i = 0; i < size; i++) {
            Item item = items.get(i);
            if (item.getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        if (index != -1) {
            return items.get(index);
        }
        return null;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items.set(index, item);
        }
        return rsl;
    }

    public void delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
//            System.arraycopy(items, index + 1, items, index, size - index - 1);
            items.addAll(index + 1, items);
            items.set(size - 1, null);
            size--;
        }
    }
}
