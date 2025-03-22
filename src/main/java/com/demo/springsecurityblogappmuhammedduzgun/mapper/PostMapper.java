package com.demo.springsecurityblogappmuhammedduzgun.mapper;

import com.demo.springsecurityblogappmuhammedduzgun.entity.Post;
import com.demo.springsecurityblogappmuhammedduzgun.request.post.CreatePostRequest;
import com.demo.springsecurityblogappmuhammedduzgun.response.post.PostResponse;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {

    //Post -> PostResponse
    public PostResponse mapToPostResponse(Post post) {
        PostResponse postResponse = new PostResponse();
        postResponse.setId(post.getId());
        postResponse.setTitle(post.getTitle());
        postResponse.setContent(post.getContent());
        postResponse.setCreationDate(post.getCreationDate());
        return postResponse;
    }

    //CreatePostRequest -> Post
    public Post mapToPost(CreatePostRequest createPostRequest) {
        Post post = new Post();
        post.setTitle(createPostRequest.getTitle());
        post.setContent(createPostRequest.getContent());
        return post;
    }

}
