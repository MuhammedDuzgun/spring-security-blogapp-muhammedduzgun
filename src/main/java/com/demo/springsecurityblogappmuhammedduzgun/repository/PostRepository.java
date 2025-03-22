package com.demo.springsecurityblogappmuhammedduzgun.repository;

import com.demo.springsecurityblogappmuhammedduzgun.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {
}
