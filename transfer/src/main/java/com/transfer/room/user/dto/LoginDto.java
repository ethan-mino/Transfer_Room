package com.transfer.room.user.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginDto {
    private String userEmail;
    private String userPassword;
}
