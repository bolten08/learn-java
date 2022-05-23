package com.learn.java.dto.user;

import com.learn.java.constraint.FieldMatch;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

//@FieldMatch(field = "password", fieldMatch = "passwordConfirm")
@FieldMatch.List({
        @FieldMatch(
                field = "password",
                fieldMatch = "passwordConfirm",
                message = "Passwords do not match!"
        ),
})
public class SignupRequest {
    @NotBlank
    @Email
    @Size(max = 50)
    private String email;

    @NotBlank
    @Size(min = 4, max = 40)
    private String password;

    @NotBlank
    @Size(min = 4, max = 40)
    private String passwordConfirm;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
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
