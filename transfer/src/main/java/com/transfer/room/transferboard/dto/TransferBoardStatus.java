package com.transfer.room.transferboard.dto;

import lombok.Getter;

@Getter
public enum TransferBoardStatus {
    // 승인 여부 (0: 미승인, 1: 승인, 2: 거절)
    PENDING(0),
    APPROVED(1),
    REJECTED(2);

    private final int value;
    TransferBoardStatus(int value){
        this.value = value;
    }
}
