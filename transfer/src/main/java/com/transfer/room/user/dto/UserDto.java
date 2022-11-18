package com.transfer.room.user.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class UserDto {
    private int userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private String userAddress;
}
