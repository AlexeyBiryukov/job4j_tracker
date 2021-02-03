package ru.job4j.ex;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenNlessThen0() {
        Fact.calc(-1);
    }

    @Test
    public void whenNGreaterThen0() {
        Fact.calc(5);
    }
}