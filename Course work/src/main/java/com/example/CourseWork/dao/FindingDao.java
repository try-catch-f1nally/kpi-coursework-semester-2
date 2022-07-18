package com.example.CourseWork.dao;

import com.example.CourseWork.model.Finding;
import com.example.CourseWork.model.User;

import java.util.List;

public interface FindingDao extends AbstractDao<Finding> {

    List<Finding> findByKeywords(List<String> keywords);

    void createFinding(String title, String description, List<String> keywords, String contactInformation, User user);

    void deleteFinding(Finding finding, User user);

}
