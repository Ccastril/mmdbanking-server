package com.mmdbanking.services;

import com.mmdbanking.models.Transaction;

import java.util.List;

public interface ITransactionService {

    List<Transaction> setAllTransactions(List<Transaction> transactions);
}
