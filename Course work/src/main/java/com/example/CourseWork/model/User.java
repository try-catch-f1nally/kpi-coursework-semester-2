package com.example.CourseWork.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {

    private Integer userId;
    private String name;
    private String login;
    private String passwordHash;
    private final List<Finding> listOfFindings;

    public User(Integer userId, String name, String login, String passwordHash) {
        this.userId = userId;
        this.name = name;
        this.login = login;
        this.passwordHash = passwordHash;
        listOfFindings = new ArrayList<>();
    }

    public Integer getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public List<Finding> getListOfFindings() {
        return listOfFindings;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void addFinding(Finding finding) {
        listOfFindings.add(finding);

    }

    public void deleteFinding(Finding finding) {
        listOfFindings.remove(finding);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.userId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        return Objects.equals(this.userId, other.userId);
    }

}
