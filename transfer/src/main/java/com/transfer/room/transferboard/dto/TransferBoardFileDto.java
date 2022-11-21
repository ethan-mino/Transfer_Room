package com.transfer.room.transferboard.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class TransferBoardFileDto {
    private int fileId; //파일 id
    private int tbId; //양도 게시글 id
    private String filePath; // 파일 경로
    private String fileContentType; //파일 콘텐츠 종류
    private int isAttachment; // 첨부 파일 여부 확인 - 1: 첨부파일, 0: 이미지파일.
}
