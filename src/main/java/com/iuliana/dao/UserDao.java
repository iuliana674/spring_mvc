package com.iuliana.dao;

import com.iuliana.model.User;

import java.util.Set;

public interface UserDao {
    public Set<User> getAllUsers();

    public User getUserById(int id);

    public User deleteUser(int id);

    public User insertUser(User user);

    public User updateUser(User user);

    public Set<User> findByFirstName(String firstName);
}