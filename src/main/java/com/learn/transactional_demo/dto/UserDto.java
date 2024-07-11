package com.learn.transactional_demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String firstName;
    private String lastName;
    private Integer age;
    private AddressDto address;
}
