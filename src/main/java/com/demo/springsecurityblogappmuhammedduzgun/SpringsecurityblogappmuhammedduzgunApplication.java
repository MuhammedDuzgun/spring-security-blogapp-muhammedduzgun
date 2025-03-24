package com.demo.springsecurityblogappmuhammedduzgun;

import com.demo.springsecurityblogappmuhammedduzgun.entity.User;
import com.demo.springsecurityblogappmuhammedduzgun.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringsecurityblogappmuhammedduzgunApplication implements CommandLineRunner {

	private final UserRepository userRepository;
	private final BCryptPasswordEncoder passwordEncoder;

    public SpringsecurityblogappmuhammedduzgunApplication(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public static void main(String[] args) {
		SpringApplication.run(SpringsecurityblogappmuhammedduzgunApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//creating test user
		String email = "user@test.com";
		userRepository.findByEmail(email).orElseGet(() -> {
			User user = new User();
			user.setEmail(email);
			user.setPassword(passwordEncoder.encode("password"));
			return userRepository.save(user);
		});
	}
}
