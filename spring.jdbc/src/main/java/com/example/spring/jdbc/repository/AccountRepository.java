package com.example.spring.jdbc.repository;

import com.example.spring.jdbc.model.Account;

import java.util.List;

public interface AccountRepository {
    int save(Account account);
    int update(Account account);
    Account findById(Integer id);
    List<Account> findAll();
    boolean existsById(Integer id);
    void deleteById(Integer id);
    int deposit(float amount, Integer id);
    int withdraw(float amount, Integer id);
}
