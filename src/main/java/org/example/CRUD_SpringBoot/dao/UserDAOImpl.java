package org.example.CRUD_SpringBoot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.CRUD_SpringBoot.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select user from User user ", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void removeUserById(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public void updateUser(int id, User newUser) {
        User oldUser = getUserById(id);
        oldUser.setName(newUser.getName());
        oldUser.setEmail(newUser.getEmail());
        entityManager.merge(oldUser);
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

}
