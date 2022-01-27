package ru.job4j.tracker.bank;

import java.util.*;

/**
 * Класс описывает работу главного сервиса BankService
 * @author adletbaitorynov
 * @version 1.0
 */
public class BankService {
    /**
     * Это поле содержит всех пользователей системы с привязанными к ним счетами
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Этот метод добавляет пользователя в систему
     * @param user принимает пользователя на входе, и добавляется методом putIfAbsent,
     * проверяя при этом есть ли эта пара в системе
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Этот метод добавляет новый счет к пользователю
     * @param passport принимает номер пасспорта пользователя на входе и
     * @param account принимает счет пользователя
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Этот метод ищет пользователя по номеру пасспорта
     * @param passport принимает на входе номер пасспорта
     * @return возвращает найденного пользователя, если же не найден то null
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Этот метод ищет счет пользователя по реквизитам
     * @param passport принимает на входе номер пасспорта
     * @param requisite принимает так же реквизиты
     * @return возвращает счет пользователя
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        return user.flatMap(value -> users.get(value)
                .stream()
                .filter(s -> s.getRequisite().equals(requisite))
                .findFirst());
    }

    /**
     * Этот метод перечисляет денежные средства с одного счета на другой счет
     * @param srcPassport принимает номер паспорта пользователя-отправителя
     * @param srcRequisite принимает реквизиты пользователя-отправителя
     * @param destPassport принимает номер паспорта бенефициара
     * @param destRequisite принимает реквизиты бенефициара
     * @param amount принимает сумму перевода
     * @return возращает булево значение, т.е. true в случае наличия баланса у отправителя
     * и наличия счета отправителя
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent() && srcAccount.get().getBalance() >= amount && destAccount.isPresent()) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            return true;
        }
        return false;
    }
}
