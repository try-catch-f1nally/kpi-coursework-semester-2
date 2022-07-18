package com.example.CourseWork.services;

import com.example.CourseWork.model.Finding;
import com.example.CourseWork.model.User;

import java.util.Collection;

public interface UserService {

    void createUser(String name, String login, String password);

    User getByLogin(String login);

    boolean checkPassword(User user, String password);

    Collection<Finding> getUsersFindings(User user);

}
