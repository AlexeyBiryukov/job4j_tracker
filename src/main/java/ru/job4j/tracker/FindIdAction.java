package ru.job4j.tracker;

public class FindIdAction implements UserAction {
    private final Output output;

    public FindIdAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return " Find by id ";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.parseInt(input.askStr("Enter id: "));
        Item item = tracker.findById(id);
        if (item != null) {
            output.println(item);
        } else {
            output.println("Data with this id was not found");
        }
        return true;
    }
}
