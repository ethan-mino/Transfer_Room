package com.transfer.room.transferboard.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class TransferBoardDetails {

    private int transferBoardId;
    private int transfererId;
    private int transfereeId;
    private int transferStatus;
    private String transferTitle;
    private String transferContent;
    private LocalDateTime transferCreateTime;
    private LocalDateTime transferUpdateTime;
    private Double roomLatitude;
    private Double roomLongitude;
    private String roomAddress;
    private int roomFloor;
    private String roomType;
    private String contractType;
    private Date contractEndTime;
    private String dongCode;
    private String sidoName;
    private String gugunName;
    private String dongName;
    private int likeCount;
    private int approvingStatus;

    /*이미지 파일과 계약서를 구분해서 넣음*/
    private List<TransferBoardFileDto> imgFilePath = new ArrayList<>();

    private List<TransferBoardFileDto> attachedFilePath = new ArrayList<>();
}
