package com.matrangola.springbootdemo.service;

import com.matrangola.springbootdemo.data.model.User;
import com.matrangola.springbootdemo.data.repository.UserRepository;
import com.matrangola.springbootdemo.exception.ResourceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUser(Long id) throws ResourceException {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) throw new ResourceException(User.class, id);
        return optionalUser.get();
    }

    // todo delete
}
