package com.example.spring.jdbc;

import com.example.spring.jdbc.model.Account;
import com.example.spring.jdbc.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AccountRepositoryTest {
    @Autowired
    AccountRepository accountRepository;

    @Test
    public void testCreateReadDelete() {
        String accountNumber = "1111122222";
        float balance = 20000;
        Account account = new Account(accountNumber,balance);
        Account savedAccount = accountRepository.save(account);

        assertNotNull(savedAccount);
        assertNotNull(savedAccount.getId());
        assertThat(savedAccount).usingRecursiveComparison().ignoringFields("id").isEqualTo(account);

        Iterable<Account> accounts = accountRepository.findAll();
        assertThat(accounts).extracting(Account::getAccountNumber).containsOnlyOnce(accountNumber);

        accountRepository.deleteAll();
        assertThat(accountRepository.findAll().isEmpty());
    }
}
