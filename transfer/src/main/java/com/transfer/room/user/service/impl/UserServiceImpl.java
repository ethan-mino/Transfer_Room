package com.transfer.room.user.service.impl;

import com.transfer.room.user.UserRole;
import com.transfer.room.user.dto.UserDto;
import com.transfer.room.user.dto.UserRoleDto;
import com.transfer.room.user.entity.UserEntity;
import com.transfer.room.user.entity.UserRoleEntity;
import com.transfer.room.user.mapper.UserMapper;
import com.transfer.room.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    /*
        * Method to verify whether user information is insertable or not
        * @param userDto User information that requires validation
     */
    private boolean userValidation(UserDto userDto) {
        String userEmail = userDto.getUserEmail();
        UserDto foundUser = userMapper.selectUserByUserEmail(userEmail);

        return foundUser == null;   // 해당 이메일의 유저가 존재한다면 false, 아니면 true 반환
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto findUserByUserEmail(String userEmail) {
        return userMapper.selectUserByUserEmail(userEmail);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto findUserByUserId(int userId) {
        return userMapper.selectUserByUserId(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserRoleDto> findUserRoleByUserId(int userId) {
        return userMapper.selectUserRoleByUserId(userId);
    }

    @Override
    @Transactional(readOnly = false)
    public boolean modifyUser(UserDto updatedUserDto) throws Exception{
        UserEntity userEntity = UserEntity.toUserDto(updatedUserDto);
        int userModifyCnt = userMapper.updateUser(userEntity);
        boolean isUserModified = (userModifyCnt == 1);
        return isUserModified;
    }

    @Override
    @Transactional(readOnly = false)
    public boolean addUser(UserDto userDto) throws Exception{
        System.out.println(userDto);
        UserEntity userEntity = UserEntity.toUserDto(userDto);
        userMapper.insertUser(userEntity);
        // TODO : 유저 이메일 중복 검사 필요
        // TODO : ROLE_USER에 해당하는 ROLE의 id를 매번 조회해야 함

        UserRoleDto userRoleDto = userMapper.selectRoleByRoleName(UserRole.ROLE_USER);
        System.out.println("teset:" + userRoleDto);

        UserRoleEntity userRoleEntity = UserRoleEntity.builder()
                .userId(userEntity.getUserId())
                .roleId(userRoleDto.getRoleId())
                .build();

        int userRoleInsertCnt = userMapper.insertUserRole(userRoleEntity);
        boolean isUserRoleInserted = (userRoleInsertCnt == 1);
        return isUserRoleInserted;
    }
}