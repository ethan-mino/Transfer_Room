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

    private int myPageStatus; //마이페이지 여부(-1이면 게시글, 나머지는 마이페이지 게시글.)

    public TransferBoardSearchFilter(){
        this.approvingStatus = -1;
        this.transferBoardId = -1;
        this.numOfRows = -1;
        this.myPageStatus = -1;
    }
}
