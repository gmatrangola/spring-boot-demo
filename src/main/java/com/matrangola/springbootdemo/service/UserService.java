package com.matrangola.springbootdemo.service;

import com.matrangola.springbootdemo.data.model.User;

public interface UserService {
    void addUser(User user);
    void updateUser(User user);

    User getUser(Long id);
}
