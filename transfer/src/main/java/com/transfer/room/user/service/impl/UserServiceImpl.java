package com.transfer.room.user.service.impl;

import com.transfer.room.user.dto.UserDto;
import com.transfer.room.user.dto.UserRoleDto;
import com.transfer.room.user.mapper.UserMapper;
import com.transfer.room.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    private boolean userValidation(UserDto userDto) {
        return false;
    }

    @Override
    public int saveUser(UserDto userDto) {
        return 0;
    }

    @Override
    public UserDto findUser(String userId) {
        return null;
    }

    @Override
    public List<UserRoleDto> findUserRole(String userId) {
        return null;
    }
}