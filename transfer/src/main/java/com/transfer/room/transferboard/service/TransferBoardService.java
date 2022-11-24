package com.transfer.room.transferboard.service;

import com.transfer.room.transferboard.dto.TransferBoardDetails;
import com.transfer.room.transferboard.dto.TransferBoardDto;
import com.transfer.room.transferboard.dto.TransferBoardSearchFilter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface TransferBoardService {
    /* 조회 */
    List<TransferBoardDetails> findTransferBoard(TransferBoardSearchFilter searchFilter); // 게시글 조회

    /* 생성 */
    boolean addTransferBoard(TransferBoardDto transferBoardDto, List<MultipartFile> boardFiles) throws Exception; //게시글 생성 메서드


    /* 수정 */
    boolean modifyTransferBoard(TransferBoardDto transferBoardDto, List<MultipartFile> boardFiles) throws Exception; //게시글 수정 메서드
    boolean modifyTransferBoardTransferee(int boardId, int transfereeId) throws Exception;

    boolean modifyTransferBoardTransferStatus(int boardId) throws Exception;
}
