package com.demo.springsecurityblogappmuhammedduzgun.dto;

import com.demo.springsecurityblogappmuhammedduzgun.response.post.PostResponse;

import java.util.List;
import java.util.UUID;

public class UserDto {

    private UUID id;

    private String email;

    private List<PostResponse> postList;

    public UserDto() {
    }

    public UserDto(UUID id, String email, List<PostResponse> postList) {
        this.id = id;
        this.email = email;
        this.postList = postList;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<PostResponse> getPostList() {
        return postList;
    }

    public void setPostList(List<PostResponse> postList) {
        this.postList = postList;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", postList=" + postList +
                '}';
    }

}
