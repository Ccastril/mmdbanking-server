package com.mmdbanking.services;

import com.mmdbanking.models.Account;

public interface IAccountService {

    public Account findOneById(String id);
}
