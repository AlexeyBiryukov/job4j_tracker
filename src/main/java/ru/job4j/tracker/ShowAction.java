package ru.job4j.tracker;

public class ShowAction implements UserAction {
    @Override
    public String name() {
        return "=== Show all items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] findItem = tracker.findAll();
        for (int i = 0; i < findItem.length; i++) {
            System.out.println(findItem[i]);
        }
        return true;
    }
}
