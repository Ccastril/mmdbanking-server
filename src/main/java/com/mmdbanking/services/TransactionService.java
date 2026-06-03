package com.mmdbanking.services;

import com.mmdbanking.models.Transaction;
import com.mmdbanking.models.User;
import com.mmdbanking.repositories.TransactionRepository;
import com.mmdbanking.repositories.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionService implements ITransactionService {

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public List<Transaction> setAllTransactions(List<Transaction> transactions) {
        List<Transaction>  result = transactionRepository.insert(transactions);
        User u = userRepository.findOneById(transactions.get(0).getUserId());
        List<Transaction> currentTransactions = u.getTransactions();
        for(Transaction transaction : transactions) {
            currentTransactions.add(transaction);
        }
        u.setTransactions(currentTransactions);
        userRepository.save(u);
        return result;
    }
}
