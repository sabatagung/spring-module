package com.example.spring_app;

import com.example.spring_app.model.Account;
import com.example.spring_app.repository.AccountRepository;
import com.example.spring_app.service.AccountService;
import com.example.spring_app.service.impl.AccountServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ExtendWith(MockitoExtension.class)
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
//        assertThat(accounts).extracting(Account::getAccountNumber).containsOnlyOnce(accountNumber);

        accountRepository.deleteAll();
        assertThat(accountRepository.findAll().isEmpty());
    }
}
