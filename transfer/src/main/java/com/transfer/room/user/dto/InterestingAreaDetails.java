package com.transfer.room.user.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
public class InterestingAreaDetails {
    private int interestingAreaId;
    private int userId;
    private String dongCode;
    private LocalDateTime interestingAreaCreateTime;

    private String sidoName;
    private String gugunName;
    private String dongName;
}
