package com.learn.transactional_demo.controller;

import com.learn.transactional_demo.dto.UserDto;
import com.learn.transactional_demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<UserDto> persistUser(@RequestBody UserDto userDto,
                                               @RequestParam(name = "isValid") Boolean isValid){
        UserDto savedUser = userService.persistUser(userDto, isValid);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}
