package com.transfer.room.transferboard.service;

import com.transfer.room.transferboard.dto.TransferBoardFileDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface TransferBoardFileService {

    /* 조회 */
    List<TransferBoardFileDto> selectTransferBoardImageFilesByTransferBoardId(int transferBoardId); //해당 게시글의 파일 전체 조회
    List<TransferBoardFileDto> selectTransferBoardAttachmentFilesByTransferBoardId(int transferBoardId);
    TransferBoardFileDto selectTransferBoardAttachmentFileByTransferBoardFileId(int transferBoardFileId);
    /* 생성 */
    boolean insertTransferBoardFile(TransferBoardFileDto transferBoardFileDto, MultipartFile transferBoardFile) throws IOException;

    /* 수정 */
    boolean modifyTransferBoardFile(TransferBoardFileDto transferBoardFileDto, MultipartFile transferBoardFile) throws Exception;
}
