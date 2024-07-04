package com.example.spring.jdbc.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Account {

    private Integer id;
    private String accountNumber;
    private float balance;

    public Account(Integer id, float balance, String accountNumber) {
        this.id = id;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }
}
