package ru.job4j.collection;

import org.junit.Test;
import ru.job4j.collection.Account;
import ru.job4j.collection.NotifyAccount;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NotifyAccountTest {

    @Test
    public void whenEnteredUniqueValues() {
        List<Account> accounts = Arrays.asList(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("142", "Petr Arsentev", "000001")
        );
        HashSet<Account> expect = new HashSet<>(
                Arrays.asList(
                        new Account("123", "Petr Arsentev", "eDer3432f"),
                        new Account("142", "Petr Arsentev", "000001")
                )
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }

    @Test
    public void whenEnteredNotUniqueValues() {
        List<Account> accounts = Arrays.asList(
                new Account("123", "Petr Arsentev", "sda322sd"),
                new Account("123", "Petr Arsentev", "sda322sd"),
                new Account("111", "Anyway Person", "asda233fdf")
        );
        HashSet<Account> expect = new HashSet<>(
                Arrays.asList(
                new Account("123", "Petr Arsentev", "sda322sd"),
                new Account("111", "Anyway Person", "asda233fdf")
                )
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }
}