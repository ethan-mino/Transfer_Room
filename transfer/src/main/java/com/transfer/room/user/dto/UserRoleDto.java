package com.transfer.room.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRoleDto {
    private int roleId;
    private int userId;
    private String roleName;
}