package com.transfer.room.transferboard.mapper;

import com.transfer.room.transferboard.dto.TransferBoardFileDto;
import com.transfer.room.transferboard.entity.TransferBoardFileEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TransferBoardFileMapper {

    /* 조회 */
    List<TransferBoardFileDto> selectTransferBoardImageFilesByTransferBoardId(int transferBoardId); //해당 게시글의 이미지 파일 전체 조회
    List<TransferBoardFileDto> selectTransferBoardAttachmentFilesByTransferBoardId(int transferBoardId); //해당 게시글의 첨부 파일 전체 조회

    TransferBoardFileDto selectTransferBoardAttachmentFileByTransferBoardFileId(int transferBoardFileId);
    /* 생성 */
    int insertTransferBoardFile(TransferBoardFileEntity transferBoardFileEntity);

    /* 수정 */
    int modifyTransferBoardFile(TransferBoardFileEntity transferBoardFileEntity);
}
