package com.demo.springsecurityblogappmuhammedduzgun.repository;

import com.demo.springsecurityblogappmuhammedduzgun.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
