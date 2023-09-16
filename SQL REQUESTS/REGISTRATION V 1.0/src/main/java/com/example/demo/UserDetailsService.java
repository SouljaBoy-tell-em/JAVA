package com.example.demo;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@FunctionalInterface
public interface UserDetailsService {

    UserDetails loadUserByFirstName(String FirstName) throws UsernameNotFoundException;
}
