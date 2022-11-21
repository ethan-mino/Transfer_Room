package com.transfer.room.transferboard.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class TransferBoardDto {
    private int transferBoardId; //게시글 id - pk
    private int transfererId; //양도인id - fk
    private int transfereeId; //양수인 id - fk
    private int transferStatus; //방 양도 상태
    private String tbTitle; //게시글 제목
    private String tbContent; //게시글 내용
    private LocalDateTime tbCreateTime;//게시글 작성일자
    private LocalDateTime tbUpdateTime; //게시글 수정일자
    private Double roomLatitude;//방 위도
    private Double roomLongitude;// 방 경도
    private String roomAddress; //방의 주소
    private int roomFloor; // 방의 층
    private String roomType; // 방 종류
    private String contractType;// 방 계약 종류
    private Date contractEndTime; //계약 종료일ㄴ
    private String dongCode; //동 코드
    private int approvingStatus;// 승인 여부 (0: 미승인, 1: 승인, 2: 거절)
    private int likeCount;// 좋아요 수
}
