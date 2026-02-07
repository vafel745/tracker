package ru.tracker;
import java.time.LocalDateTime;

public class Item {
    private int id;
    private String name;
    static LocalDateTime created = LocalDateTime.now();

    public Item() {

    }

    public Item(String name) {
        this.name = name;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Item item = new Item();
        Item item1 = new Item("Ball");
        Item item2 = new Item(1, "Car");
    }

}