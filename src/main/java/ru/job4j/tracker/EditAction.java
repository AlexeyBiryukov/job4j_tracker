package ru.job4j.tracker;

public class EditAction implements UserAction{
    @Override
    public String name() {
        return "=== Edit item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.parseInt(input.askStr("Enter id: "));
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("=== Editing is done ===");
        } else {
            System.out.println("=== Not found ===");
        }
        return true;
    }
}
