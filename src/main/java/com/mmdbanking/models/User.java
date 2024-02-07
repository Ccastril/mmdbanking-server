package com.mmdbanking.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Getter @Setter @ToString
@Document(collection="users")
public class User {

    @Id
    private ObjectId id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    @DocumentReference(lazy = true)
    private List<Account> accounts;

    public User(ObjectId id, String firstName, String lastName, String email, String username, String password, List<Account> accounts) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return this.id + " " + this.firstName + " " + this.lastName + " " + this.email + " " + this.username + " " + this.password + this.accounts.toString();
    }

}
