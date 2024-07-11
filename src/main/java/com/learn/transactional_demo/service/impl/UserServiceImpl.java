package com.learn.transactional_demo.service.impl;

import com.learn.transactional_demo.dto.AddressDto;
import com.learn.transactional_demo.dto.UserDto;
import com.learn.transactional_demo.entity.Address;
import com.learn.transactional_demo.entity.User;
import com.learn.transactional_demo.repository.AddressRepository;
import com.learn.transactional_demo.repository.UserRepository;
import com.learn.transactional_demo.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    public UserServiceImpl(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    @Transactional
    public UserDto persistUser(UserDto userDto, Boolean isValid) {

        User user = getUser(userDto);
        userRepository.save(user);

        if(!isValid) {
            throw new RuntimeException("Simulating a failure");
        }

        Address address = getAddress(userDto);
        addressRepository.save(address);

        return userDto;
    }

    private User getUser(UserDto userDto) {
        return new User().builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .age(userDto.getAge())
                .build();
    }

    private Address getAddress(UserDto userDto) {
        AddressDto addressDto = userDto.getAddress();
        return new Address().builder()
                .no(addressDto.getNo())
                .lane(addressDto.getLane())
                .city(addressDto.getCity())
                .province(addressDto.getProvince())
                .build();
    }
}
