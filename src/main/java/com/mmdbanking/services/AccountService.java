package com.mmdbanking.services;

import com.mmdbanking.models.Account;
import com.mmdbanking.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account findOneById(String id) {
        return accountRepository.findOneById(id);
    }
}
;