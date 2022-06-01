package com.learn.java.controller;

import com.learn.java.dto.user.SigninRequest;
import com.learn.java.dto.user.SignupRequest;
import com.learn.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity getUser(Principal principal) {
        return ResponseEntity.ok(userService.getUser(principal.getName()));
    }

    @PostMapping("/signin")
    public ResponseEntity signIn(@Valid @RequestBody SigninRequest signinRequest) {
        return ResponseEntity.ok(userService.signIn(signinRequest));
    }

    @PostMapping("/signup")
    public ResponseEntity signUp(@Valid @RequestBody SignupRequest signupRequest) {
        userService.signUp(signupRequest);
        return ResponseEntity.ok().build();
    }
}
