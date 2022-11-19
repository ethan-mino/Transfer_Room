package com.transfer.room.transferboard.service.impl;

import com.transfer.room.transferboard.dto.TransferBoardDto;
import com.transfer.room.transferboard.dto.TransferBoardListDto;
import com.transfer.room.transferboard.entity.TransferBoardFilesEntity;
import com.transfer.room.transferboard.entity.TransferBoardsEntity;
import com.transfer.room.transferboard.mapper.TransferBoardFilesMapper;
import com.transfer.room.transferboard.mapper.TransferBoardMapper;
import com.transfer.room.transferboard.service.TransferBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TransferBoardServiceImpl implements TransferBoardService {

    //롬복을 이용하여 생성자 주입
    private final TransferBoardMapper transferBoardMapper;
    private final TransferBoardFilesMapper transferBoardFilesMapper;


    @Override
    @Transactional(readOnly = true)
    public TransferBoardDto findTransferBoardByArticleId(int articleId) {

        TransferBoardDto transferBoardDto = transferBoardMapper.selectTransferBoardByArticleId(articleId); //양도 게시글 정보 조회
        List<TransferBoardFilesEntity> transferBoardFilesEntityList = transferBoardFilesMapper.selectTransferBoardFilesByArticleId(transferBoardDto.getArticleId());
        transferBoardDto = transferBoardDto.insertFile(transferBoardFilesEntityList);//게시글에 들어갈 파일 조회

        return transferBoardDto;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TransferBoardListDto> findTransferBoardByDongCode(String dongCode) {

        List<TransferBoardListDto> transferBoardListDtos = transferBoardMapper.selectTransferBoardByDongCode(dongCode); //동코드로 게시글 조회
        //각 게시글에 대해 파일 정보 조회.
        for(int index = 0; index < transferBoardListDtos.size(); index++){
            int tempArticleId = transferBoardListDtos.get(index).getArticleId(); //리스트에서 id값 꺼내오기
            List<TransferBoardFilesEntity> transferBoardFilesEntityList = transferBoardFilesMapper.selectTransferBoardFilesByArticleId(tempArticleId); //id값으로 파일 조회.
            transferBoardListDtos.get(index).insertImgFile(transferBoardFilesEntityList); //해당 객체에 파일경로를 담음
        }
        return transferBoardListDtos;
    }


    //게시판 생성의 경우, 이미지 파일, 계약서도 저장되어야 하기 떄문에 손봐야됨.(수정중)
    @Override
    @Transactional(readOnly = false)
    public boolean addTransferBoard(TransferBoardsEntity transferBoardsEntity) throws Exception {
        return true;
    }
}
