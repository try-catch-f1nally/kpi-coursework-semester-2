package com.example.CourseWork.dao.impl.inmemory;

import com.example.CourseWork.dao.UserDao;
import com.example.CourseWork.model.Finding;
import com.example.CourseWork.model.User;

import java.util.Collection;

class InMemoryUserDao extends InMemoryAbstractDao<User> implements UserDao {

    InMemoryUserDao(InMemoryDatabase database) {
        super(database.users, User::getUserId, User::setUserId, database);
    }


    @Override
    public User createUser(String name, String login, String password) {
        User user = new User(-1 , name, login, password);
        this.insert(user, true);
        return null;
    }

    @Override
    public User getByLogin(String login) {
        return database.users.values()
                .stream()
                .filter(user -> user.getLogin().equals(login))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Finding> getUsersFindings(User user) {
        return user.getListOfFindings();
    }

}
