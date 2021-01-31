package ru.job4j.tracker;

public class EditAction implements UserAction{
    private final Output output;

    public EditAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Edit";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.parseInt(input.askStr("Enter id: "));
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            output.println("=== Editing is done ===");
        } else {
            output.println("=== Not found ===");
        }
        return true;
    }
}
