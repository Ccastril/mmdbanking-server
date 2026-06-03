package com.mmdbanking.controllers;

import com.mmdbanking.models.Transaction;
import com.mmdbanking.services.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("transactions")
public class TransactionController {

    @Autowired
    private ITransactionService transactionService;

    @PostMapping("/add_transactions")
    @ResponseBody
    public ResponseEntity<String> insert(@RequestBody List<Transaction> transactions) {

        List<Transaction> addedTransactions = transactionService.setAllTransactions(transactions);
        return ResponseEntity.status(HttpStatus.OK).body("This sit hte resposnef rom the add transactions uri to transctions" + " " + addedTransactions.toString());
    }
}
