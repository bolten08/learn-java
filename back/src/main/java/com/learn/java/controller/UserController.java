package com.learn.java.controller;

import com.learn.java.exception.user.UserAlreadyExistException;
import com.learn.java.exception.user.UserNotFoundException;
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
        try {
            return ResponseEntity.ok(userService.getUser(principal.getName()));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

    @PostMapping("/signin")
    public ResponseEntity signIn(@Valid @RequestBody SigninRequest signinRequest) {
        return ResponseEntity.ok(userService.signIn(signinRequest));
    }

    @PostMapping("/signup")
    public ResponseEntity signUp(@Valid @RequestBody SignupRequest signupRequest) {
        System.out.println("[Request] /user/signup");
        try {
            userService.signUp(signupRequest);
            return ResponseEntity.ok().build();
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }
}
