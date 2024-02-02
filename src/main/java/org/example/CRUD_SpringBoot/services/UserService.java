package org.example.CRUD_SpringBoot.services;


import org.example.CRUD_SpringBoot.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void addUser(User user);
    void removeUserById(int id);
    void updateUser(int id, User user);
    User getUserById(int id);
}
