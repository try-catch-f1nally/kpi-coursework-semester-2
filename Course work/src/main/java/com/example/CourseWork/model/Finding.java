package com.example.CourseWork.model;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class Finding {

    private Integer findingId;
    private String title;
    private String description;
    private List<String> keywords;
    private String contactInformation;
    private Instant instant;
    private User creatorOfFinding;

    public Finding(Integer findingId, String title, String description, List<String> keywords, String contactInformation, User creatorOfFinding) {
        this(findingId, title, description, keywords, contactInformation, Instant.now(), creatorOfFinding);
    }

    public Finding(Integer findingId, String title, String description, List<String> keywords,
                   String contactInformation, Instant instant, User creatorOfFinding) {
        this.findingId = findingId;
        this.title = title;
        this.description = description;
        this.keywords = keywords;
        this.contactInformation = contactInformation;
        this.instant = instant;
        this.creatorOfFinding = creatorOfFinding;
    }

    public Integer getFindingId() {
        return findingId;
    }

    public void setFindingId(Integer findingId) {
        this.findingId = findingId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public Instant getInstant() {
        return instant;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }

    public User getCreatorOfFinding() {
        return creatorOfFinding;
    }

    public void setCreatorOfFinding(User creatorOfFinding) {
        this.creatorOfFinding = creatorOfFinding;
    }

    public Date getDate() {
        return Date.from(instant);
    }
}
