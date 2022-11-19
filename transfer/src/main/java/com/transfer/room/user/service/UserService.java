package com.transfer.room.user.service;

import com.transfer.room.user.dto.UserDto;
import com.transfer.room.user.dto.UserRoleDto;

import java.util.List;

public interface UserService {
    boolean modifyUser(UserDto userDto) throws Exception;
    boolean addUser(UserDto userDto) throws Exception;   // 유저 정보 생성 메서드
    UserDto findUserByUserId(int userId); // userId를 이용한 유저 정보 조회 메서드
    UserDto findUserByUserEmail(String userEmail); // userId를 이용한 유저 정보 조회 메서드
    List<UserRoleDto> findUserRoleByUserId(int userId); // userId를 이용한 유저 권한 조회 메서드
}