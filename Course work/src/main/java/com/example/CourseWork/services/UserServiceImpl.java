package com.example.CourseWork.services;

import com.example.CourseWork.dao.DaoFactory;
import com.example.CourseWork.model.Finding;
import com.example.CourseWork.model.User;

import java.util.Collection;
import java.util.function.UnaryOperator;

public class UserServiceImpl implements UserService {
    DaoFactory daoFactory;
    UnaryOperator<String> passwordHasher;

    public UserServiceImpl(DaoFactory daoFactory, UnaryOperator<String> passwordHasher) {
        this.daoFactory = daoFactory;
        this.passwordHasher = passwordHasher;
    }

    @Override
    public void createUser(String name, String login, String password) {
        daoFactory.getUserDao().createUser(name, login, password);
    }

    @Override
    public User getByLogin(String login) {
        return daoFactory.getUserDao().getByLogin(login);
    }

    @Override
    public boolean checkPassword(User user, String password) {
        return user.getPasswordHash().equals(passwordHasher.apply(password));
    }

    @Override
    public Collection<Finding> getUsersFindings(User user) {
        return daoFactory.getUserDao().getUsersFindings(user);
    }
}
