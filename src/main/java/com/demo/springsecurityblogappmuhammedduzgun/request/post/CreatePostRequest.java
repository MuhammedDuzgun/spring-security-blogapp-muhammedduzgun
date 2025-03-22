package com.demo.springsecurityblogappmuhammedduzgun.request.post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreatePostRequest {

    @NotBlank(message = "title cannot be blank")
    @Size(min = 1, max = 35, message = "title min 1, max 35 characters")
    private String title;

    @NotBlank(message = "content cannot be blank")
    @Size(min = 1, max = 300, message = "content min 1, nax 300 characters")
    private String content;

    public CreatePostRequest() {
    }

    public CreatePostRequest(String title, String content) {
        this.title = title;
        this.content = content;
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

    @Override
    public String toString() {
        return "CreatePostRequest{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

}
