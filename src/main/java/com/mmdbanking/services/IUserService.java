package com.mmdbanking.services;

import com.mmdbanking.templates.LoginFormTemplate;
import com.mmdbanking.models.User;

import java.util.List;

public interface IUserService {
    public List<User> login(LoginFormTemplate loginTemplate);

    public User save(User userTemplate);

    public User findOneById(String id);
}
