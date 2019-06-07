package com.project.architect.userlogin.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class UserDTO {

    private Long id;

    @NotNull
    @Pattern(regexp = "^[[a-zA-Z0-9]+]{5,}$",
            message = "Invalid username. Please enter a new username")
    private String username;

    @NotNull
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(.{8,})$",
            message = "Invalid password. Please enter a new password")
    private String password;

    public UserDTO() {
    }
}
