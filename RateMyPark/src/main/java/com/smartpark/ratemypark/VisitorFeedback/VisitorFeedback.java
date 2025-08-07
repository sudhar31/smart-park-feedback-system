package com.smartpark.ratemypark.VisitorFeedback;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "visitor_feedback")
public class VisitorFeedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name= "issue_type")
    private String issueType;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    private String status;

    public VisitorFeedback(){

    }

    @PrePersist //this will automatically set default
    public void prePersist() {
        if (this.timestamp == null) {
            this.timestamp = LocalDateTime.now();
        }
        if (this.status == null) {
            this.status = "OPEN";
        }
    }

    public VisitorFeedback(Long id, String name, String issueType, String description, LocalDateTime timestamp, String status) {
        this.id = id;
        this.name = name;
        this.issueType = issueType;
        this.description = description;
        this.timestamp = timestamp;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "VisitorFeedback{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", issueType='" + issueType + '\'' +
                ", description='" + description + '\'' +
                ", timestamp=" + timestamp +
                ", status='" + status + '\'' +
                '}';
    }
}
