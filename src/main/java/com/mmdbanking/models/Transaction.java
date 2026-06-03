package com.mmdbanking.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter @Setter @AllArgsConstructor @ToString
@Document(collection="transactions")
public class Transaction {

    @Id
    private ObjectId id;
    private ObjectId userId;
    private String date;
    private String destination;
    private TransactionType transactionType;
    private Number transactionAmount;
}
