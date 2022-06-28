package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getUserAll();

    User getUserIndex(int index);

    void saveUser(User user);

    void updateUser(int id,User user);

    void deleteUser(int id);

    //User uploadUserForm(int id,String name,String surName);

}
