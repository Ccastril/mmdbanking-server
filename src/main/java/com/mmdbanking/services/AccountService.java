package com.mmdbanking.services;

import com.mmdbanking.models.Account;
import com.mmdbanking.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public Account findOneById(String id) {
        return accountRepository.findOneById(id);
    }

    public List<Account> saveAll(List<Account> accounts) {
        System.out.println("these are teh accounts you are trying to save " + accounts.toString());
        List<Account> insertedAccounts = accountRepository.saveAll(accounts);




        System.out.println("these are teh accounts you have saved"  + insertedAccounts.toString());
        return insertedAccounts;
    }




}
;