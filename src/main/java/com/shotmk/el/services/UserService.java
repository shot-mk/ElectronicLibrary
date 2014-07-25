package com.shotmk.el.services;

import com.shotmk.el.entity.User;

public interface UserService {

    public User getUser(String login);

    public User addUser(User user);

}
