package com.example.CourseWork.dao;

import com.example.CourseWork.model.Finding;
import com.example.CourseWork.model.User;

import java.util.Collection;

public interface UserDao extends AbstractDao<User> {

    User createUser(String name, String login, String password);

    User getByLogin(String login);

    Collection<Finding> getUsersFindings(User user);

}
