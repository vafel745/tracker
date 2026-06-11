package ru.tracker.action;

import ru.tracker.input.Input;
import ru.tracker.Tracker;

public interface User {
    String name();

    boolean execute(Input input, Tracker tracker);
}
