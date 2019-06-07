package com.project.architect.userlogin.service.impl;

import com.project.architect.userlogin.dto.UserDTO;
import com.project.architect.userlogin.entity.User;
import com.project.architect.userlogin.mapper.UserMapper;
import com.project.architect.userlogin.repository.UserRepository;
import com.project.architect.userlogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public String saveUser(UserDTO user) throws ConstraintViolationException {
        repository.save(UserMapper.mapToEntity(user));
        return user.getUsername();
    }

    @Override
    public Optional<User> findByUsername(String username) {
         List<User> users = (List<User>) repository.findAll();
         return users.stream()
                 .filter(user -> user.getUsername().equals(username))
                 .findFirst();
    }

}
