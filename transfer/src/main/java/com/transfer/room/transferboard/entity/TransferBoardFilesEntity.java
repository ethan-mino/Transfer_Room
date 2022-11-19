package com.transfer.room.transferboard.entity;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TransferBoardFilesEntity {


    private int fileId; //파일 id
    private int tbId; //양도 게시글 id
    private String filePath; // 파일 경로
    private String fileContentType; //파일 콘텐츠 종류
    private int isAttachment; // 첨부 파일 여부 확인 - 1: 첨부파일, 0: 이미지파일.

    // TODO: 2022-11-19 게시글 저장시에 dto를 entity로 변환하는 빌더 필요.

}
