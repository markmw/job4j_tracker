package ru.job4j.bank;

import org.junit.Test;
import ru.job4j.bank.Account;
import ru.job4j.bank.BankService;
import ru.job4j.bank.User;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class BankServiceTest {
    @Test
    public void addUser() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        Optional<User> user1 = bank.findByPassport("3434");
        user1.ifPresent(value -> assertThat(value, is(user)));
    }

    @Test
    public void whenEnterInvalidPassport() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        Optional<Account> account = bank.findByRequisite("34", "5546");
        account.ifPresent(value -> assertThat(value, is(Optional.empty())));
    }

    @Test
    public void addAccount() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        Optional<Account> account = bank.findByRequisite("3434", "5546");
        account.ifPresent(value -> assertThat(value.getBalance(), is(150D)));
    }

    @Test
    public void transferMoney() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 150D);
        Optional<Account> account = bank.findByRequisite(user.getPassport(), "113");
        account.ifPresent(value -> assertThat(value.getBalance(), is(200D)));
    }

    @Test
    public void add2Accounts() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("1111", 150D));
        bank.addAccount(user.getPassport(), new Account("1122", 300D));
        Optional<Account> account = bank.findByRequisite(user.getPassport(), "1122");
        account.ifPresent(value -> assertThat(value.getBalance(), is(300D)));
    }
}