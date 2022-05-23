package com.learn.java.dto.user;

import com.learn.java.entity.UserEntity;


public class UserDto {
    private String email;
    private String firstName;
    private String lastName;

    public static UserDto toDto (UserEntity entity) {
        UserDto user = new UserDto();
        user.setEmail(entity.getEmail());
        user.setFirstName(entity.getFirstName());
        user.setLastName(entity.getLastName());
        return user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
