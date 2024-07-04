package com.example.demo.service;

import com.example.demo.exception.AccountAlreadyExistsException;
import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;
import jakarta.transaction.Transactional;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public Account save(Account account){
        return accountRepository.save(account);
//        try {
//            return accountRepository.save(account);
//        } catch (DataIntegrityViolationException e){
//            throw new AccountAlreadyExistsException("Account already exists!", e);
//        }catch (ConstraintViolationException e) {
//            throw new AccountAlreadyExistsException("Account already exists!", e);
//        }
    }

    public Account findId(Long id){
        return accountRepository.findById(id).get();
    }

    public List<Account> findAll(){
        return accountRepository.findAll();
    }

    public void deleteId(Long id){
        accountRepository.deleteById(id);
    }

    public List<Account> findByName (String accountNumber){
        return accountRepository.findByAccountNumber(accountNumber);
    }

}
