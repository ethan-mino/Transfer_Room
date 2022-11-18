package com.transfer.room.user.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RoleEntity {
    private String roleId;
    private String roleName;
}
