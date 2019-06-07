package com.project.architect.userlogin.service;

import com.project.architect.userlogin.dto.UserDTO;
import com.project.architect.userlogin.entity.User;

import javax.validation.ConstraintViolationException;
import java.util.Optional;

public interface UserService {
    String saveUser(UserDTO user) throws ConstraintViolationException;
    Optional<User> findByUsername(String username);
}
