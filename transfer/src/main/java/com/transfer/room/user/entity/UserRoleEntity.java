package com.transfer.room.user.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRoleEntity {
    private int id;
    private String userId;
    private String roleName;

    public UserRoleEntity(String userId, String roleName) {
        this.userId = userId;
        this.roleName = roleName;
    }
}