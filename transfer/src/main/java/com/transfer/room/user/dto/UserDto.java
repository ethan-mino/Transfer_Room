package com.transfer.room.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter
@Setter
public class UserDto {
    // TODO : validation 필요
    private int userId;
    private String userName;
    private String userEmail;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String userPassword;
    private String userAddress;

    private LocalDateTime userCreateTime;
    private LocalDateTime userUpdateTime;
}
