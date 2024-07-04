package com.example.spring_app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.lenient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.spring_app.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.Any;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.spring_app.model.Account;
import com.example.spring_app.repository.AccountRepository;
import com.example.spring_app.service.impl.AccountServiceImpl;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {
    @Mock
    AccountRepository accountRepo;

    @InjectMocks
    AccountService accountService = new AccountServiceImpl();

    @BeforeEach
    void setMockOutput() {
        List<Account> accountList = new ArrayList<Account>();
        accountList.add(new Account("1982094121",10000));
        accountList.add(new Account("1982094122",10000));
        accountList.add(new Account("1982094123",10000));
        accountList.add(new Account("1982094124",10000));
        accountList.add(new Account("1982094125",10000));

        lenient().when(accountRepo.findAll()).thenReturn(accountList);
        lenient().when(accountRepo.existsById(anyInt())).thenReturn(Boolean.TRUE);
        lenient().when(accountRepo.findById(anyInt())).thenReturn(Optional.of(new Account("11111",1000)));
    }

    @Test
    void testFindAll() {
        List<Account> accountList = accountService.listAll();

        assertEquals(5, accountList.size());
        // try {} catch (Exception e) {}
        verify(accountRepo, times(1)).findAll();
    }

    @Test
    void testCreateAccount() {
        Account account = new Account("1982094125",10000);

        accountService.save(account);

        verify(accountRepo, times(1)).save(account);
    }
//    @Test
//    void testGet()
    @Test
    void testWithdraw() {
        float amount = 1000;
        Integer id = 1;
        accountService.withdraw(amount, id);
        verify(accountRepo, times(1)).withdraw(amount, id);
    }
}
