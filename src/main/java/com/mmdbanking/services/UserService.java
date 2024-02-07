package com.mmdbanking.services;
import com.mmdbanking.repositories.UserRepository;
import com.mmdbanking.templates.LoginFormTemplate;
import com.mmdbanking.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> login(LoginFormTemplate loginTemplate) {
        //test get a user
        List<User> users = userRepository.findAll(loginTemplate.getUsername());
        return users;
    }

    @Override
    public User save(User userTemplate) {
//        User newUser = new User(null, userTemplate.getFirstName(), userTemplate.getLastName(), userTemplate.getEmail(), userTemplate.getUsername(), userTemplate.getPassword());
//
//        userRepository.save(newUser);
        return userTemplate;
    }

    @Override
    public User findOneById(String id) {
        User returnedUser = userRepository.findOneById(id);
        return returnedUser;
    }

//    public User insertOne(User user) {
//        userRepository.save(user);
//        System.out.println("user saved to repo");
//        return user;
//    }
}
