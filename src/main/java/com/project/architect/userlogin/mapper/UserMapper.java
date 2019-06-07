package com.project.architect.userlogin.mapper;

import com.project.architect.userlogin.dto.UserDTO;
import com.project.architect.userlogin.entity.User;

public class UserMapper {

    public static User mapToEntity(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());

        return user;
    }
}
