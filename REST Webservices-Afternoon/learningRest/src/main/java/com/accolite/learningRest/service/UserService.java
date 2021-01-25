package com.accolite.learningRest.service;

import com.accolite.learningRest.entity.UserData;


public interface UserService {
    public UserData addUser(UserData user);

    public UserData getUserById(Integer id);

    public UserData updateUser(UserData user);

    public String deleteUser(Integer id);

}
