package com.example.authc.controllers;

import com.example.authc.model.LoginRequest;
import com.example.authc.service.JWTService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Authentication", description = "Endpoints for authenticate the user")
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    JWTService service;

    @Operation(summary = "Signin the user")
    @PostMapping("/signin")
    public String authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        return service.createJWT(loginRequest);
    }

}
