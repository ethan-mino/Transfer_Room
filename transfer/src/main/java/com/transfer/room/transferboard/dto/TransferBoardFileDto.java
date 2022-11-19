package com.transfer.room.transferboard.dto;

import com.transfer.room.transferboard.entity.TransferBoardFilesEntity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TransferBoardFileDto {

    private int fileId; //파일 id
    private String fileUrl; // 파일 url


    /*파일 엔티티를 받아서 파일 다운로드가 가능한 url로 반환.*/
    public TransferBoardFileDto(TransferBoardFilesEntity transferBoardFilesEntity){

        this.fileId = transferBoardFilesEntity.getFileId();
        // TODO: 2022-11-19 파일 다운로드 컨트롤러 제작후, url를 만드는 코드 필요. 현재는 일반 문자열로,
        this.fileUrl = "url:" + transferBoardFilesEntity.getFilePath();
    }

}
