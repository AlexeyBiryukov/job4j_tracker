package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item item1 = new Item();

        tracker.add(item1);

        System.out.println(tracker.findById(0));
    }
}