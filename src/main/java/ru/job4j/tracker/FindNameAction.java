package ru.job4j.tracker;

public class FindNameAction implements UserAction {
    private final Output output;

    public FindNameAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Find by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item[] item = tracker.findByName(name);
        if (item.length > 0) {
            for (int i = 0; i < item.length; i++) {
                output.println(item[i]);
            }
        } else {
            output.println("Data with this name was not found");
        }
        return true;
    }
}
