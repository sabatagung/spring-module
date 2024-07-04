package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//After use any annotation you dont need curly brackets
@RestController
@RequestMapping ("/api/accounts")
public class AccountController {

        @Autowired
        AccountService accountService;

        @GetMapping
        public List<Account>findAll(){
        return accountService.findAll();
    }

//      @GetMapping
//      public Iterable<Account> findAll(){
//          return accountService.findAll();
//      }

//      @PostMapping
//      public Account save(@RequestBody Account account){
//          return accountService.save(account);
//      }


        @PostMapping
        public HttpEntity <Account>save(@RequestBody Account account){
            Account savedAccount = accountService.save(account);
            return new ResponseEntity<>(accountService.save(account), HttpStatus.CREATED);
        }
//    @PostMapping
//    public ResponseEntity<Account> save(@RequestBody Account account) {
//        Account savedAccount = accountService.save(account);
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(savedAccount.getId())
//                .toUri();
//        return ResponseEntity.created(location).body(savedAccount);
//    }


}
