package com.example.spring.dev;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

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
        verify(accountRepo, times(1)).findAll();
    }

    @Test
    void testCreateAccount() {
        Account account = new Account("1982094125",10000);

        accountService.save(account);

        verify(accountRepo, times(1)).save(account);
    }

    @Test
    void testWithdraw() {
        float amount = 1000;
        Integer id = 1;
        accountService.withdraw(amount, id);
        verify(accountRepo, times(1)).withdraw(amount, id);
    }
}
