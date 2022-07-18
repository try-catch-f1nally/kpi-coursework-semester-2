package com.example.CourseWork.services;

import com.example.CourseWork.model.Finding;
import com.example.CourseWork.model.User;

import java.util.Collection;
import java.util.List;

public interface FindingService {

    Collection<Finding> getAllFindings();

    List<Finding> searchByKeyWords(List<String> keywords);

    Finding getFindingById(Integer findingId);

    void createFinding(String title, String description, List<String> keywords, String contactInformation, User user);

    void deleteFinding(Finding finding, User user);

}
