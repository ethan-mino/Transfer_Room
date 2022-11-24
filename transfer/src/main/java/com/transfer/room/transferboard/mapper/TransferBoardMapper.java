package com.transfer.room.transferboard.mapper;

import com.transfer.room.transferboard.dto.TransferBoardDetails;
import com.transfer.room.transferboard.dto.TransferBoardSearchFilter;
import com.transfer.room.transferboard.entity.TransferBoardEntity;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TransferBoardMapper {

    /* 조회 */
    List<TransferBoardDetails> selectTransferBoard(TransferBoardSearchFilter searchFilter); // 게시물 번호(컬럼 명 td_id)를 이용하여 유저 정보 조회

    /*생성*/
    int insertTransferBoard(TransferBoardEntity transferBoardEntity) throws Exception; //게시글 생성 메서드


    /*수정*/
    int updateTransferBoard(TransferBoardEntity transferBoardEntity) throws Exception; //게시글 수정 메서드
    int updateTransferBoardTransferee(@Param("transfereeId")int transfereeId,int transferBoardId) throws Exception;
    int updateTransferBoardTransferStatus(int transferBoardId) throws Exception;
}
