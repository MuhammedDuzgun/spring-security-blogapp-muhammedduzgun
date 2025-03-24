package com.demo.springsecurityblogappmuhammedduzgun.controller;

import com.demo.springsecurityblogappmuhammedduzgun.request.post.CreatePostRequest;
import com.demo.springsecurityblogappmuhammedduzgun.response.post.PostResponse;
import com.demo.springsecurityblogappmuhammedduzgun.security.BlogUserDetails;
import com.demo.springsecurityblogappmuhammedduzgun.service.PostService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    //Create Post
    @PostMapping
    public ResponseEntity<PostResponse> createPost(@AuthenticationPrincipal BlogUserDetails userDetails,
                                                   @Valid @RequestBody CreatePostRequest createPostRequest) throws AuthenticationException {
        PostResponse createdPost = postService.createPost(createPostRequest, userDetails);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    //Get All Posts
    @GetMapping
    public ResponseEntity<List<PostResponse>> getAllPosts() {
        List<PostResponse> allPosts = postService.getAllPosts();
        return ResponseEntity.ok(allPosts);
    }

    //Get Post By ID
    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> getPostById(@PathVariable("id") UUID id) {
        PostResponse postResponse = postService.getPostById(id);
        return ResponseEntity.ok(postResponse);
    }

    //Delete Post By ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePostById(@AuthenticationPrincipal BlogUserDetails userDetails,
                                               @PathVariable("id") UUID id) {
        postService.deletePostById(userDetails, id);
        return ResponseEntity.noContent().build();
    }

}
