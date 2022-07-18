package com.example.CourseWork.dao.impl.inmemory;

import com.example.CourseWork.dao.FindingDao;
import com.example.CourseWork.model.Finding;
import com.example.CourseWork.model.User;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryFindingDao extends InMemoryAbstractDao<Finding> implements FindingDao {

    public InMemoryFindingDao(InMemoryDatabase database) {
        super(database.findings, Finding::getFindingId, Finding::setFindingId, database);
    }

    @Override
    public List<Finding> findByKeywords(List<String> keywords) {
        return database.findings.values().stream()
                .collect(Collectors.toMap(f -> f, f -> checkKeywordsOfFinding(f, keywords)))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .filter(e -> e.getValue() != 0)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public void createFinding(String title, String description, List<String> keywords, String contactInformation, User user) {
        Finding finding = new Finding(-1, title, description, keywords, contactInformation, user);
        insert(finding, true);
        user.addFinding(finding);
    }

    @Override
    public void deleteFinding(Finding finding, User user) {
        user.deleteFinding(finding);
        delete(finding);
    }

    private Integer checkKeywordsOfFinding(Finding finding, List<String> keywordsOfSearching) {
        int numberOfCoincidences = 0;
        for (String keywordOfFinding : finding.getKeywords()) {
            for (String keywordOfSearching : keywordsOfSearching) {
                if (keywordOfFinding.equalsIgnoreCase(keywordOfSearching))
                    numberOfCoincidences++;
            }
        }
        return -numberOfCoincidences;
    }

}
