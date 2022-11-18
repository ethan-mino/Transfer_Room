package com.transfer.room.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRoleDto {
    private int id;
    private String userId;
    private String roleName;

    public UserRoleDto(String userId, String roleName) {
        this.userId = userId;
        this.roleName = roleName;
    }
}