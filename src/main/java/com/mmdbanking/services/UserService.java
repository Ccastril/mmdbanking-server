package com.mmdbanking.services;
import com.mmdbanking.models.Account;
import com.mmdbanking.repositories.AccountRepository;
import com.mmdbanking.repositories.UserRepository;
import com.mmdbanking.templates.LoginFormTemplate;
import com.mmdbanking.models.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mmdbanking.models.AccountTypes;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRespository;

    @Override
    public List<User> login(LoginFormTemplate loginTemplate) {
        //test get a user
        List<User> users = userRepository.findAll(loginTemplate.getUsername());
        return users;
    }

    @Override
    public User save(User userTemplate) {
        List<Account> accountsList = new ArrayList<>();
        User newUser = new User(null, userTemplate.getFirstName(), userTemplate.getLastName(), userTemplate.getEmail(), userTemplate.getUsername(), userTemplate.getPassword(), null);
        Account newAccount = new Account(null, null, AccountTypes.SAVINGS, "000000000",0.0);
        accountsList.add(newAccount);
        newUser.setAccounts(accountsList);
        userRepository.save(newUser);
        return userTemplate;
    }

    @Override
    public User findOneById(String id) {
        User returnedUser = userRepository.findOneById(id);
        return returnedUser;
    }

    @Override
    @Transactional
    public User createUserEmptyAccount(User newUser) {

        ObjectId newUserId = new ObjectId();
        ObjectId newAccountId = new ObjectId();
        Account emptyAccount = new Account(newAccountId, newUserId, AccountTypes.UNDEFINED, "000000000", 0.0);
        List<Account> accountList = new ArrayList<>();

        newUser.setId(newUserId);
        accountList.add(emptyAccount);
        newUser.setAccounts(accountList);

        userRepository.save(newUser);
        accountRespository.save(emptyAccount);
        return newUser;
    }

//    public User insertOne(User user) {
//        userRepository.save(user);
//        System.out.println("user saved to repo");
//        return user;
//    }
}
