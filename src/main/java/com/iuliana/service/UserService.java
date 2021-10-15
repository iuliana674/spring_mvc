package com.iuliana.service;

import com.iuliana.dao.UserDao;
import com.iuliana.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Set<User> getAllUsers() {
        try(Session session = sessionFactory.openSession()){
            return new HashSet<>(session.createQuery("FROM User").list());
        }
    }

    @Override
    public User getUserById(int id) {
        try(Session session = sessionFactory.openSession()){
            return session.find(User.class, id);
        }
    }

    @Override
    public User deleteUser(int id) {
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            User user = getUserById(id);
            session.delete(user);
            transaction.commit();
            return user;
        }
    }

    @Override
    public User insertUser(User user) {
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            return user;
        }
    }

    @Override
    public User updateUser(User user) {
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
            return user;
        }
    }

    @Override
    public Set<User> findByFirstName(String firstName) {
        return getAllUsers().stream().
           filter(user -> user.getFirstName().equals(firstName)).collect(Collectors.toSet());
    }
}
