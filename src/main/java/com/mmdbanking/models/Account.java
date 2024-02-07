package com.mmdbanking.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Getter @Setter @NoArgsConstructor
@Document(collection="accounts")
public class Account {

    @Id
    private String id;
    private String accountOwnerId;
    private Enum<AccountTypes> accountType;
    private String routingNumber;
    private Double balance;

    public Account(String id, String accountOwnerId, Enum<AccountTypes> accountType, String routingNumber, Double balance) {
        super();
        this.id = id;
        this.accountOwnerId = accountOwnerId;
        this.accountType = accountType;
        this.routingNumber = routingNumber;
        this.balance = balance;
    }



}
