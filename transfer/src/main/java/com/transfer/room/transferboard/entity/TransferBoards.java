package com.transfer.room.transferboard.entity;

import java.time.LocalDateTime;

public class TransferBoards {

    private int tbId; //게시글 id - pk
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
}
