package com.eql.Hotel.services;

import com.eql.Hotel.dto.UserDto;
import com.eql.Hotel.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    void saveUser(UserDto userDto);

    User findUserByEmail(String email);
    UserDto mappingUser(User user);
    List<UserDto> findAllUsers();



}
