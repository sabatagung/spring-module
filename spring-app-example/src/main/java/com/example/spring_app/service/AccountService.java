package com.example.spring_app.service;

import com.example.spring_app.model.Account;

import java.util.List;

public interface AccountService {
    List<Account> listAll();

    Account get(Integer id);

    Account save(Account account);

    Account deposit(float amount, Integer id);

    Account withdraw(float amount, Integer id);

    void delete(Integer id);
}
