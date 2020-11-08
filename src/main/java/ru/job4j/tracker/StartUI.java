package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item item1 = new Item();
        Item item2 = new Item();

        tracker.add(item1);
        tracker.add(item2);

        item1.setName("item1");
        item1.setId(1);

        item2.setName("item2");
        item2.setId(2);

        System.out.println(tracker.findById(1));
    }
}