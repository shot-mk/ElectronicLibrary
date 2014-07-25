package com.shotmk.el.services.impl;

import com.shotmk.el.entity.User;
import com.shotmk.el.repository.UserRepository;
import com.shotmk.el.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser(String login) {
        return userRepository.findOne(login);
    }

    @Override
    public User addUser(User user) {
        User newUser = userRepository.saveAndFlush(user);
        return newUser;
    }

}
