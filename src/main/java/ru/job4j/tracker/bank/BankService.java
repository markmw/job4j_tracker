package ru.job4j.tracker.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Этот метод добавляет новый счет к пользователю
     * @param passport принимает номер пасспорта пользователя на входе и
     * @param account принимает счет пользователя
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
                users.get(user).add(account);
            }
    }

    /**
     * Этот метод ищет пользователя по номеру пасспорта
     * @param passport принимает на входе номер пасспорта
     * @return возвращает найденного пользователя, если же не найден то null
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Этот метод ищет счет пользователя по реквизитам
     * @param passport принимает на входе номер пасспорта
     * @param requisite принимает так же реквизиты
     * @return возвращает счет пользователя
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (requisite.equals(account.getRequisite())) {
                    return account;
                }
            }
        }
        return null;
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
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && srcAccount.getBalance() >= amount && destAccount != null) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            return true;
        }
        return false;
    }
}
