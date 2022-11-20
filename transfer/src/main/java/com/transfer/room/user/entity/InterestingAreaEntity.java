package com.transfer.room.user.entity;

import com.transfer.room.user.dto.InterestingAreaDto;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@Builder
public class InterestingAreaEntity {
    private int interestingAreaId;
    private int userId;
    private String dongCode;
    private LocalDateTime interestingAreaCreateTime;

    public static InterestingAreaEntity toInterestingAreaDto(InterestingAreaDto interestingAreaDto){
        return InterestingAreaEntity.builder().interestingAreaId(interestingAreaDto.getInterestingAreaId())
                .userId(interestingAreaDto.getUserId())
                .dongCode(interestingAreaDto.getDongCode())
                .interestingAreaCreateTime(interestingAreaDto.getInterestingAreaCreateTime())
                .build();
    }
}
