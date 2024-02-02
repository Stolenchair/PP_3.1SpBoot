package org.example.CRUD_SpringBoot.dao;


import org.example.CRUD_SpringBoot.models.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    void addUser(User user);
    void removeUserById(int id);
    void updateUser(int id, User user);
    User getUserById(int id);
}
