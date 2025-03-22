package com.demo.springsecurityblogappmuhammedduzgun.service;

import com.demo.springsecurityblogappmuhammedduzgun.entity.Post;
import com.demo.springsecurityblogappmuhammedduzgun.exception.EntityNotFoundException;
import com.demo.springsecurityblogappmuhammedduzgun.mapper.PostMapper;
import com.demo.springsecurityblogappmuhammedduzgun.repository.PostRepository;
import com.demo.springsecurityblogappmuhammedduzgun.request.post.CreatePostRequest;
import com.demo.springsecurityblogappmuhammedduzgun.response.post.PostResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public PostService(PostRepository postRepository, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    //Create Post
    @Transactional
    public PostResponse createPost(CreatePostRequest createPostRequest) {
        Post postToCreate = postMapper.mapToPost(createPostRequest);
        Post createdPost = postRepository.save(postToCreate);
        return postMapper.mapToPostResponse(createdPost);
    }

    //Get All Posts
    public List<PostResponse> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(postMapper::mapToPostResponse).toList();
    }

    //Get Post By ID
    public PostResponse getPostById(UUID id) {
        Post post = postRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Post with id " + id + " not found"));
        return postMapper.mapToPostResponse(post);
    }

    //Delete Post By Id
    @Transactional
    public void deletePostById(UUID id) {
        postRepository.deleteById(id);
    }

}
