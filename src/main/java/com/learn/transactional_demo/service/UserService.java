package com.learn.transactional_demo.service;

import com.learn.transactional_demo.dto.UserDto;

public interface UserService {
    UserDto persistUser(UserDto userDto, Boolean isValid);
}
