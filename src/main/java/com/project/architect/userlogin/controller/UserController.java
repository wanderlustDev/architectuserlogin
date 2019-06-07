package com.project.architect.userlogin.controller;

import com.project.architect.userlogin.dto.UserDTO;
import com.project.architect.userlogin.entity.User;
import com.project.architect.userlogin.enums.Message;
import com.project.architect.userlogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Displays user registration form
     * @return user/register
     */
    @GetMapping(value = "/register")
    public String register() {
        return "user/register";
    }

    /**
     * Creates a new user from the registration form
     * SendS error messages back to the UI
     * @param model
     * @param userDTO
     * @param bindingResult
     * @return user/register
     */
    @PostMapping(value = "/create")
    public String createUser(ModelMap model, @Valid UserDTO userDTO, BindingResult bindingResult) {
        // stores any constraint validation errors to
        // send back to the front-end
        if (bindingResult.hasErrors()) {
            model.addAttribute(Message.VALIDATION_ERRORS.value(),
                    bindingResult.getAllErrors().stream()
                            .map(ObjectError::getDefaultMessage)
                            .collect(Collectors.toList()));
            return "user/register";
        }

        // check if user exists before persisting in the DB
        // if user exists return error message to UI
        Optional<User> existingUser = userService.findByUsername(userDTO.getUsername());
        if (existingUser.isPresent()) {
            model.addAttribute(Message.USER_ALREADY_EXISTS.value(), Message.USER_ALREADY_EXISTS.message());
            return "user/register";
        }
        userService.saveUser(userDTO);
        model.addAttribute(Message.SUCCESS.value(), Message.SUCCESS.message());
        return "user/register";
    }

}
