package com.demo.springsecurityblogappmuhammedduzgun.service;

import com.demo.springsecurityblogappmuhammedduzgun.entity.Post;
import com.demo.springsecurityblogappmuhammedduzgun.entity.User;
import com.demo.springsecurityblogappmuhammedduzgun.exception.EntityNotFoundException;
import com.demo.springsecurityblogappmuhammedduzgun.mapper.PostMapper;
import com.demo.springsecurityblogappmuhammedduzgun.repository.PostRepository;
import com.demo.springsecurityblogappmuhammedduzgun.request.post.CreatePostRequest;
import com.demo.springsecurityblogappmuhammedduzgun.response.post.PostResponse;
import com.demo.springsecurityblogappmuhammedduzgun.security.BlogUserDetails;
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
    public PostResponse createPost(CreatePostRequest createPostRequest, BlogUserDetails blogUserDetails) {
        Post postToCreate = postMapper.mapToPost(createPostRequest);
        postToCreate.setUser(blogUserDetails.getUser());
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
    public void deletePostById(BlogUserDetails userDetails, UUID id) {
        User user = userDetails.getUser();
        //is post exists
        Post postToDelete = postRepository.findById(id)
                        .orElseThrow(()-> new EntityNotFoundException("Post with id " + id + " not found"));
        //is post belongs to user
        if (!postToDelete.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("this post does not belong to user");
        }
        postRepository.deleteById(id);
    }

}
