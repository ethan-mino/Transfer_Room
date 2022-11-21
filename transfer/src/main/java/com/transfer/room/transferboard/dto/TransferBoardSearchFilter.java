package com.transfer.room.transferboard.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TransferBoardSearchFilter {
    private int transferBoardId;
    private int numOfRows;
    private int approvingStatus;

    private String userEmail;
    private String dongCode;
    private String order;

    public TransferBoardSearchFilter(){
        this.approvingStatus = -1;
        this.transferBoardId = -1;
        this.numOfRows = -1;
    }
}
