package com.project.project.controllers;


import com.project.project.JWT.AuthService;
import com.project.project.requests.jwt_requests.JwtAuthResponse;
import com.project.project.requests.auth_requests.LoginRequest;
import com.project.project.requests.auth_requests.RegisterRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthRestController {

    @Autowired
    private AuthService authenticationService;

    @PostMapping("/register")
    public JwtAuthResponse signUp(@RequestBody @Valid RegisterRequest request) {
        return authenticationService.Register(request);
    }

    @PostMapping("/login")
    public JwtAuthResponse signIn(@RequestBody @Valid LoginRequest request) {
        return authenticationService.Authorization(request);
    }
}

