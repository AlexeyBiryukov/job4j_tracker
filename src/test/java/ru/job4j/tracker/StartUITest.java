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
        Item item = tracker.add(new Item("Replaced item"));
        String perlacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0","1","New item name","1"}
        );
        UserAction[] actions = {
                new EditAction(),
                new Exit()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(perlacedName));
    }


    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Delete item"));
        Input in = new StubInput(
                new String[] {"0","1","1"}
        );
        UserAction[] actions = {
                new DeleteAction(),
                new Exit()
        };
        new StartUI().init(in, tracker, actions);
        Item nullValue = null;
        assertThat(tracker.findById(item.getId()), is(nullValue));
    }

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(
                new String[] {"0", "Item name","1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new Exit()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }
}
