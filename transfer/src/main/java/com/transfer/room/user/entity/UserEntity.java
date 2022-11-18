package com.transfer.room.user.entity;

import com.transfer.room.user.dto.UserDto;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@Builder
public class UserEntity {
    private int userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private String userAddress;

    public static UserEntity toUserDto(UserDto userDto){
        return UserEntity.builder().userId(userDto.getUserId())
                .userEmail(userDto.getUserEmail())
                .userName(userDto.getUserEmail())
                .userPassword(userDto.getUserPassword())
                .userAddress(userDto.getUserPassword())
                .build();
    }
}
