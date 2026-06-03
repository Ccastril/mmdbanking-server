package com.mmdbanking.services;

import com.mmdbanking.models.Account;

import java.util.List;

public interface IAccountService {

    public Account findOneById(String id);
    public List<Account> saveAll(List<Account> accounts);
}
