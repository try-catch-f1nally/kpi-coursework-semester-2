package com.example.CourseWork.dao.impl.inmemory;

import com.example.CourseWork.dao.DaoFactory;
import com.example.CourseWork.model.Finding;
import com.example.CourseWork.model.User;

import java.util.Map;
import java.util.TreeMap;

public class InMemoryDatabase {
    Map<Integer, Finding> findings;
    Map<Integer, User> users;

    public InMemoryDatabase() {
        findings = new TreeMap<>();
        users = new TreeMap<>();
    }

    public DaoFactory getDaoFactory() {
        return new InMemoryDaoFactory(this);
    }
}
