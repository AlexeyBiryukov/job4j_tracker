package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenAddItem() {
        String[] answer = {"Fix PC"};
        Input input = new StubInput(answer);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }


    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answer = {
                String.valueOf(item.getId()),
                "replace item"
        };
        StartUI.editItem(new StubInput(answer), tracker);
        Item editItem = tracker.findById(item.getId());
        assertThat(editItem.getName(), is("replace item"));
    }


    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answer = {
                String.valueOf(item.getId()),
        };
        StartUI.deleteItem(new StubInput(answer), tracker);
        String[] deleteItem = new String[0];
        assertThat(tracker.findAll(), is(deleteItem));
    }
}
