package com.transfer.room.transferboard.mapper;

import com.transfer.room.transferboard.entity.TransferBoardFilesEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TransferBoardFilesMapper {

    /*조회*/
    //해당 게시글의 파일 전체 조회.
    List<TransferBoardFilesEntity> selectTransferBoardFilesByArticleId(int articleId);

    /*생성*/

    /*수정*/

}
