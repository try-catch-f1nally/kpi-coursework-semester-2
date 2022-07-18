package com.example.CourseWork.dao.impl.inmemory;

import com.example.CourseWork.dao.DaoFactory;
import com.example.CourseWork.dao.FindingDao;
import com.example.CourseWork.dao.UserDao;


public class InMemoryDaoFactory implements DaoFactory {

    InMemoryDatabase database;

    FindingDao findingDao;
    UserDao userDao;

    InMemoryDaoFactory(InMemoryDatabase database) {
        this.database = database;

        findingDao = new InMemoryFindingDao(database);;
        userDao = new InMemoryUserDao(database);
    }

    public FindingDao getFindingDao() {
        return findingDao;
    }

    @Override
    public UserDao getUserDao() {
        return userDao;
    }
}
