package com.demo.springsecurityblogappmuhammedduzgun.response.post;

import java.time.LocalDateTime;
import java.util.UUID;

public class PostResponse {

    private UUID id;
    private String title;
    private String content;
    private LocalDateTime creationDate;

    public PostResponse() {
    }

    public PostResponse(UUID id, String title, String content, LocalDateTime creationDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "PostResponse{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }

}
