package com.demo.springsecurityblogappmuhammedduzgun.request.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public class CreateUserRequest {

    @Email
    private String email;

    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$",
            message = "Şifre en az 8 karakter olmalı, bir büyük harf, bir küçük harf, bir rakam ve bir özel karakter içermelidir."
    )
    private String password;

    public CreateUserRequest() {
    }

    public CreateUserRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
