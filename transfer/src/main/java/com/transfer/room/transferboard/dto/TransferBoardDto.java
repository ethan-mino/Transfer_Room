package com.transfer.room.transferboard.dto;

import com.transfer.room.transferboard.entity.TransferBoardFilesEntity;
import lombok.Getter;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class TransferBoardDto {

    private int articleId;
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
    private String sidoName;
    private String gugunName;
    private String dongName;
    private int likeCount;


    /*이미지 파일과 계약서를 구분해서 넣음*/
    private List<TransferBoardFileDto> imgFilePath = new ArrayList<>();

    private List<TransferBoardFileDto> attachedFilePath = new ArrayList<>();

    /*연관관계 메서드를 통해서 따로 조회한 transfer_board_files 테이블 객체를 받아서 넣어줌*/
    public TransferBoardDto insertFile(List<TransferBoardFilesEntity> transferBoardFileEntities){

        for(TransferBoardFilesEntity transferBoardFile : transferBoardFileEntities){
            //계약서와 이미지 파일 분리.
            if(transferBoardFile.getIsAttachment() == 1){
                //첨부 파일(계약서)일 경우.
                attachedFilePath.add(new TransferBoardFileDto(transferBoardFile));
            }
            else{
                imgFilePath.add(new TransferBoardFileDto(transferBoardFile));
            }
        }

        return this;
    }
}
