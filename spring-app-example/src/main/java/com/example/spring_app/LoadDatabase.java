package com.example.spring_app;

import com.example.spring_app.model.Account;
import com.example.spring_app.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class LoadDatabase {
    private AccountRepository accountRepo;

    public LoadDatabase(AccountRepository accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Bean
    public CommandLineRunner initDatabase() {
        return args -> {

            Account account1 = new Account("1982080187", 1023.99f);
            Account account2 = new Account("1982032178", 234.50f);
            Account account3 = new Account("1982094129", 6215.00f);

            accountRepo.saveAll(List.of(account1, account2, account3));

            System.out.println("Sample database initialized.");
        };
    }
}
