package com.transfer.room.user.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class InterestingAreaDto {
    private int interestingAreaId;
    private int userId;
    private String dongCode;
    private LocalDateTime interestingAreaCreateTime;
}
