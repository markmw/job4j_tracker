package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindNameActionTest {
    @Test
    public void whenFindNameAction() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item(1, "New Item");
        tracker.add(item);
        FindNameAction find = new FindNameAction(out);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("New Item");
        find.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Find items by name..." + ln + item + ln));
    }
}