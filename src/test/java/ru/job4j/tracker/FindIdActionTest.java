package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindIdActionTest {
    @Test
    public void whenFindIdAction() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item(1, "New Item");
        tracker.add(item);
        FindIdAction find = new FindIdAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        find.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Find item by id..." + ln + item + ln));
    }
}