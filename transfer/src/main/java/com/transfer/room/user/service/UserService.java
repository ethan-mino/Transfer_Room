package com.transfer.room.user.service;

import com.transfer.room.user.dto.UserDto;
import com.transfer.room.user.dto.UserRoleDto;

import java.util.List;

public interface UserService {
    int saveUser(UserDto userDto);
    UserDto findUser(String userEmail);
    List<UserRoleDto> findUserRole(String loginId);
}