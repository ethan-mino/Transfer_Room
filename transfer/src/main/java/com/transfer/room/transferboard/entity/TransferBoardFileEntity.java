package com.transfer.room.transferboard.entity;


import com.transfer.room.transferboard.dto.TransferBoardFileDto;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TransferBoardFileEntity {
    private int fileId; //파일 id
    private int tbId; //양도 게시글 id
    private String filePath; // 파일 경로
    private String fileContentType; //파일 콘텐츠 종류
    private int isAttachment; // 첨부 파일 여부 확인 - 1: 첨부파일, 0: 이미지파일.

    public static TransferBoardFileEntity toTransferBoardFileDto(TransferBoardFileDto transferBoardFileDto){
        return TransferBoardFileEntity.builder()
                .fileId(transferBoardFileDto.getFileId())
                .tbId(transferBoardFileDto.getTbId())
                .fileContentType(transferBoardFileDto.getFileContentType())
                .filePath(transferBoardFileDto.getFilePath())
                .isAttachment(transferBoardFileDto.getIsAttachment())
                .build();
    }
}
