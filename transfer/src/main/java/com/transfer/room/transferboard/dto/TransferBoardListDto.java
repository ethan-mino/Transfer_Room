package com.transfer.room.transferboard.dto;

import com.transfer.room.transferboard.entity.TransferBoardFilesEntity;
import lombok.Getter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

//여러 양도글을 지도에서 볼때.
@Getter
public class TransferBoardListDto {
    //방은 양도 상태가 가능 상태 인것만 보여줌.
    //웹뷰에서 슬라이드해서 볼수 있는 간단한 정보들.


    private int transferBoardId; //게시글 단건 조회시 필요하기 때문에 가지고 있어야 됨
    private String transferTitle; //게시글 제목
    private Double roomLatitude; // 위도 - 맵에 좌표를 찍기 위함.
    private Double roomLongitude;// 경도
    private int roomFloor;// 층
    private String roomType; // 방 종류
    private String contractType; //방 계약 종류
    private Date contractEndTime;
    private int likeCount;

    private List<TransferBoardFileDto> imgFilePath = new ArrayList<>(); // 여러 사진중 대표 사진만 보여주면 됨.

    /*게시판 리스트에는 첨부파일이 필요 없기 때문에, 사진만 가져와서 보여줌.*/
    public TransferBoardListDto insertImgFile(List<TransferBoardFilesEntity> transferBoardFileEntities){
        for(TransferBoardFilesEntity transferBoardFile : transferBoardFileEntities){
            //계약서와 이미지 파일 분리.
            if(transferBoardFile.getIsAttachment() == 0){
                imgFilePath.add(new TransferBoardFileDto(transferBoardFile));
            }
        }

        return this;
    }



}
