package com.demo.springsecurityblogappmuhammedduzgun.controller;

import com.demo.springsecurityblogappmuhammedduzgun.request.auth.LoginRequest;
import com.demo.springsecurityblogappmuhammedduzgun.response.auth.AuthResponse;
import com.demo.springsecurityblogappmuhammedduzgun.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthenticationService authenticationService;

    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        UserDetails userDetails = authenticationService.authenticate(
                loginRequest.getEmail(),
                loginRequest.getPassword()
        );
        String token = authenticationService.generateToken(userDetails);
        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(token);
        return ResponseEntity.ok(authResponse);
    }

}
