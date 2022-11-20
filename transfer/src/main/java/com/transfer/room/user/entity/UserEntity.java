package com.transfer.room.user.entity;

import com.transfer.room.user.dto.UserDto;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter
@Builder
public class UserEntity {
    private int userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private String userAddress;
    private LocalDateTime userCreateTime;
    private LocalDateTime userUpdateTime;

    public static UserEntity toUserDto(UserDto userDto){
        return UserEntity.builder().userId(userDto.getUserId())
                .userEmail(userDto.getUserEmail())
                .userName(userDto.getUserName())
                .userPassword(userDto.getUserPassword())
                .userAddress(userDto.getUserAddress())
                .build();
    }
}
