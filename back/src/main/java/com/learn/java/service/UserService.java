package com.learn.java.service;

import com.learn.java.config.jwt.JwtUtils;
import com.learn.java.dto.user.SigninRequest;
import com.learn.java.dto.user.JwtResponse;
import com.learn.java.dto.user.SignupRequest;
import com.learn.java.dto.user.UserDto;
import com.learn.java.entity.UserEntity;
import com.learn.java.exception.user.UserAlreadyExistException;
import com.learn.java.exception.user.UserNotFoundException;
import com.learn.java.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    private UserRepository userRepository;

    public UserEntity signUp(SignupRequest signupRequest) throws UserAlreadyExistException {
        if (userRepository.findByEmail(signupRequest.getEmail()).isPresent()) {
            throw new UserAlreadyExistException("Пользователь уже существует");
        }

        UserEntity user = new UserEntity(
                signupRequest.getEmail(),
                passwordEncoder.encode(signupRequest.getPassword()),
                signupRequest.getFirstName(),
                signupRequest.getLastName()
        );

        return userRepository.save(user);
    }

    public JwtResponse signIn(SigninRequest signinRequest) {
        String email = signinRequest.getEmail();
        String password = signinRequest.getPassword();

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(email, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtils.generateToken(authentication);

        return new JwtResponse(jwt);
    }

    public UserDto getUser(String email) throws UserNotFoundException {
        UserEntity user = userRepository
                .findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("Пользователь не найден"));

        return UserDto.toDto(user);
    }
}
