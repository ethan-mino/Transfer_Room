package com.transfer.room.user.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserRoleEntity {
    private int userId;
    private int roleId;
}