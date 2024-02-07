package com.mmdbanking.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter @Setter @NoArgsConstructor @ToString
@Document(collection="accounts")
public class Account {

    @Id
    private  ObjectId id;
    private ObjectId accountOwnerId;
    private AccountTypes accountType;
    private String routingNumber;
    private Double balance;

    public Account(ObjectId id, ObjectId accountOwnerId, AccountTypes accountType, String routingNumber, Double balance) {
        super();
        this.id = id;
        this.accountOwnerId = accountOwnerId;
        this.accountType = accountType;
        this.routingNumber = routingNumber;
        this.balance = balance;
    }



}
