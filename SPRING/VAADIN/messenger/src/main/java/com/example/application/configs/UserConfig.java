package com.example.application.configs;


import com.example.application.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;


@Configuration
public class UserConfig {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public ArrayList<UserDetails> USER_BASE() {
        return new ArrayList<UserDetails>(userRepository.findAll());
    }
}
