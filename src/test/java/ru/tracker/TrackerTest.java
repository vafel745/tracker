package ru.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TrackerTest {
    @Test
    public void whenTestFindById() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        Item item = tracker.add(bug);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName()).isEqualTo(item.getName());
    }

    @Test
    public void whenTestFindAll() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        Item result = tracker.findAll()[0];
        assertThat(result.getName()).isEqualTo(first.getName());
    }

    @Test
    public void whenTestFindByNameCheckArrayLength() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        Item[] result = tracker.findByName(first.getName());
        assertThat(result.length).isEqualTo(3);
    }

    @Test
    public void whenTestFindByNameCheckSecondItemName() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        Item[] result = tracker.findByName(second.getName());
        assertThat(result[1].getName()).isEqualTo(second.getName());
    }

    @Test
    public void whenTestFindAll10() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        Item third  = new Item("Three");
        Item fourth  = new Item("Four");
        Item fifth   = new Item("Five");
        Item sixth  = new Item("Six");
        Item seventh  = new Item("Seven");
        Item eighth  = new Item("Eight");
        Item ninth  = new Item("Nine");
        Item tenth = new Item("Ten");
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        tracker.add(fourth);
        tracker.add(fifth);
        tracker.add(sixth);
        tracker.add(seventh);
        tracker.add(eighth);
        tracker.add(ninth);
        tracker.add(tenth);
        Item result = tracker.findAll()[4];
        assertThat(result.getName()).isEqualTo(fifth.getName());
    }
}