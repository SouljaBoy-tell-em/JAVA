package com.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.*;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests((requests) -> requests
                   .requestMatchers("/").permitAll()
                   .anyRequest().authenticated())
                   .formLogin((form) -> form.loginPage("/login")
                   .defaultSuccessUrl("/profile").permitAll())
                   .logout((logout) -> logout.permitAll()).build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {

        List<UserDetails> UserList = new ArrayList<>();
        Iterator<User> iterator = userRepository.findAll().iterator();
        while(iterator.hasNext()) {
            UserList.add(iterator.next());
        }
        return new InMemoryUserDetailsManager(UserList);
    }
}
