package ru.job4j.tracker;

public class ShowAction implements UserAction {
    private final Output output;

    public ShowAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return " Show all ";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] findItem = tracker.findAll();
        for (int i = 0; i < findItem.length; i++) {
            output.println(findItem[i]);
        }
        return true;
    }
}
