package ru.job4j.tracker;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class HbmTrackerTest {
    @Test
    public void whenAdd() {
        HbmTracker tracker = new HbmTracker();
        Item item = new Item(1, "name1", LocalDateTime.now());
        tracker.add(item);
        List<Item> items =  tracker.findAll();
        assertThat(items.size(), is(1));
        assertThat(items.get(0).getId(), is(item.getId()));
        assertThat(items.get(0).getName(), is(item.getName()));
        assertThat(items.get(0).getCreated().withNano(0), is(item.getCreated().withNano(0)));
    }

    @Test
    public void whenReplace() {
        HbmTracker tracker = new HbmTracker();
        Item item = new Item(1, "name1", LocalDateTime.now());
        tracker.add(item);
        Item itemNew = new Item(1, "name2", LocalDateTime.now());
        tracker.replace(1, itemNew);
        List<Item> items =  tracker.findAll();
        assertThat(items.size(), is(1));
        assertThat(items.get(0).getId(), is(itemNew.getId()));
        assertThat(items.get(0).getName(), is(itemNew.getName()));
        assertThat(items.get(0).getCreated().withNano(0), is(itemNew.getCreated().withNano(0)));
    }

    @Test
    public void whenDelete() {
        HbmTracker tracker = new HbmTracker();
        Item item1 = new Item(1, "name1", LocalDateTime.now());
        tracker.add(item1);
        Item item2 = new Item(2, "name2", LocalDateTime.now());
        tracker.add(item2);
        List<Item> items1 =  tracker.findAll();
        assertThat(items1.size(), is(2));
        tracker.delete(2);
        List<Item> items2 =  tracker.findAll();
        assertThat(items2.size(), is(1));
    }

    @Test
    public void whenFindAll() {
        HbmTracker tracker = new HbmTracker();
        Item item1 = new Item(1, "name1", LocalDateTime.now());
        tracker.add(item1);
        Item item2 = new Item(2, "name2", LocalDateTime.now());
        tracker.add(item2);
        List<Item> items1 =  tracker.findAll();
        assertThat(items1.size(), is(2));
    }

    @Test
    public void whenFindByName() {
        HbmTracker tracker = new HbmTracker();
        Item item1 = new Item(1, "name1", LocalDateTime.now());
        tracker.add(item1);
        Item item2 = new Item(2, "name1", LocalDateTime.now());
        tracker.add(item2);
        List<Item> rsl =  tracker.findByName("name1");
        assertThat(rsl.size(), is(2));
    }

    @Test
    public void whenFindById() {
        HbmTracker tracker = new HbmTracker();
        Item item1 = new Item(1, "name1", LocalDateTime.now());
        tracker.add(item1);
        Item item2 = new Item(2, "name1", LocalDateTime.now());
        tracker.add(item2);
        Item rsl1 =  tracker.findById(1);
        assertThat(rsl1, is(item1));
        Item rsl2 =  tracker.findById(2);
        assertThat(rsl2, is(item2));
    }
}