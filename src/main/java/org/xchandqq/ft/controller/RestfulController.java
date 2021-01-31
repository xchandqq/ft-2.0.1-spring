/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xchandqq.ft.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xchandqq.ft.models.Account;
import org.xchandqq.ft.models.Transaction;
import org.xchandqq.ft.models.User;
import org.xchandqq.ft.repository.AccountRepository;
import org.xchandqq.ft.repository.TransactionRepository;
import org.xchandqq.ft.repository.UserRepository;

/**
 *
 * @author Christian
 */
@RestController
@RequestMapping("api/v1/")
public class RestfulController {
    
    @Autowired
    UserRepository userRepository;   
    
    @Autowired
    AccountRepository accountRepository;  
    
    @Autowired
    TransactionRepository transactionRepository;    
    
    //users only
    @GetMapping("users")
    public List<User> getAll(){
        return userRepository.findAll();
    }
    
    @GetMapping("users/{id}")
    public User getUser(@PathVariable("id") long id){
        return userRepository.findById(id).orElse(null);
    }
    
    @PostMapping("add-user")
    public List<User> addUser(@RequestBody final User user){
        userRepository.save(user);
        return getAll();
    }
    
    //users-account only
    @GetMapping("users/{id}/accounts")
    public List<Account> getAccountsByUserId(@PathVariable("id") long id){
        if(!userRepository.existsById(id)) return null;
        return accountRepository.findByUserId(id);
    }
    
    @PostMapping("users/{id}/add-account")
    public List<Account> addAccount(@PathVariable("id") long id, @RequestBody final Account account){
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()) return null;
        account.setUser(user.get());
        accountRepository.save(account);
        return getAccountsByUserId(id);
    }
    
    @GetMapping("users/{u_id}/accounts/{a_id}")
    public Account getAccountByAccountId(@PathVariable("u_id") long u_id, @PathVariable("a_id") long a_id){
        if(!userRepository.existsById(u_id)) return null;
        else return accountRepository.findByIdAndUserId(a_id, u_id).orElse(null);
    }
    
    @GetMapping("users/{u_id}/accounts/{a_id}/transactions")
    public List<Transaction> getAll(@PathVariable("u_id") long u_id, @PathVariable("a_id") long a_id){
        if(!userRepository.existsById(u_id)) return null;
        else if(!accountRepository.existsById(a_id)) return null;
        else return transactionRepository.findByAccountToIdOrAccountFromId(a_id, a_id);
    }
    
//    @PostMapping("users/{u_id}/accounts/{a_id}/add-transaction")
//    public List<Account> addAccount(@PathVariable("u_id") long u_id, @PathVariable("a_id") long a_id, @RequestBody final Transaction transaction) throws ResourceNotFoundException{
////        User user = getUser(u_id).getBody();
////        Account account = getAccountsByUserId(user.getId());
////        account.setUser(user);
////        accountRepository.save(account);
////        return getAccountsByUserId(id);
//    }
}
