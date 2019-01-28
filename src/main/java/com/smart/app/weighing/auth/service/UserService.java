package com.smart.app.weighing.auth.service;

import com.smart.app.weighing.model.User;

public interface UserService {
    void save(User user);

    User findByLogin(String login);
}
