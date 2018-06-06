package com.matrangola.springbootdemo.service;

import com.matrangola.springbootdemo.data.model.User;
import com.matrangola.springbootdemo.exception.ResourceException;

public interface UserService {
    void addUser(User user);
    void updateUser(User user);

    User getUser(Long id) throws ResourceException;
}
