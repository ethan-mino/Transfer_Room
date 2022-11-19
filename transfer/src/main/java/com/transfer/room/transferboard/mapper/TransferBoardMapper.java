package com.transfer.room.transferboard.mapper;

import com.transfer.room.transferboard.dto.TransferBoardDto;
import com.transfer.room.transferboard.dto.TransferBoardListDto;
import com.transfer.room.transferboard.entity.TransferBoardsEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TransferBoardMapper {

    /*조회*/
    TransferBoardDto selectTransferBoardByArticleId(int articleId); // 게시물 번호(컬럼 명 td_id)를 이용하여 유저 정보 조회
    List<TransferBoardListDto> selectTransferBoardByDongCode(String dongCode); //동 코드를 이용해서 조회.

    /*생성*/
    int insertTransferBoard(TransferBoardsEntity transferBoardsEntity) throws Exception; //게시글 생성 메서드


    /*수정*/

}
