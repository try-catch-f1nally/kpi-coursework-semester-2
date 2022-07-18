package com.example.CourseWork.services;

import com.example.CourseWork.dao.DaoFactory;
import com.example.CourseWork.model.Finding;
import com.example.CourseWork.model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FindingServiceImpl implements FindingService {
    DaoFactory daoFactory;

    public FindingServiceImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Collection<Finding> getAllFindings() {
        return daoFactory.getFindingDao().findAll();
    }

    @Override
    public List<Finding> searchByKeyWords(List<String> keywords) {
        if (keywords == null || keywords.size() == 0) {
            return new ArrayList<>(getAllFindings());
        }
        return daoFactory.getFindingDao().findByKeywords(keywords);
    }

    @Override
    public Finding getFindingById(Integer findingId) {
        return daoFactory.getFindingDao().get(findingId);
    }

    @Override
    public void createFinding(String title, String description, List<String> keywords, String contactInformation, User user) {
        daoFactory.getFindingDao().createFinding(title, description, keywords, contactInformation, user);
    }

    @Override
    public void deleteFinding(Finding finding, User user) {
        daoFactory.getFindingDao().deleteFinding(finding, user);
    }
}
