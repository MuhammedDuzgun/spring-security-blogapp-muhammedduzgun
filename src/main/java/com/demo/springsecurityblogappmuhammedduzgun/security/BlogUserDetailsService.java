package com.demo.springsecurityblogappmuhammedduzgun.security;

import com.demo.springsecurityblogappmuhammedduzgun.entity.User;
import com.demo.springsecurityblogappmuhammedduzgun.exception.EntityNotFoundException;
import com.demo.springsecurityblogappmuhammedduzgun.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class BlogUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public BlogUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
                .orElseThrow(()-> new EntityNotFoundException("User not found"));
        return new BlogUserDetails(user);
    }

}
