package com.goodcars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodcars.entity.Account;
import com.goodcars.entity.Cart;
import com.goodcars.repo.AccountRepo;

@Service
public class AccountService {

    @Autowired
    AccountRepo accountRepo;
    
    public Account save(Account account, Cart cart) {
        
       account.setCart(cart);
      
       return accountRepo.save(account);
    }

    public Account getById(Integer id) {

        return accountRepo.findById(id).get();

    }

    public Account login(Account account){

        Account loggedin = accountRepo.getAccountByEmailAndPassword(account.getEmail(), account.getPassword());
        
        if (loggedin==null){
            return null;
        }
        
        return loggedin;
        
    }

    public Account getByEmail (String email){

        Account account = accountRepo.getAccountByEmail(email);

        if (account==null){
            return null;
        }

        return account;
    }

    public Account update(Account account) {

      return accountRepo.save(account);
    }

    public void deleteById(Account account) {

        accountRepo.delete(account);
    }

}
