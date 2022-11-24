package com.transfer.room.transferboard.service.impl;

import com.transfer.room.transferboard.dto.TransferBoardDetails;
import com.transfer.room.transferboard.dto.TransferBoardDto;
import com.transfer.room.transferboard.dto.TransferBoardFileDto;
import com.transfer.room.transferboard.dto.TransferBoardSearchFilter;
import com.transfer.room.transferboard.entity.TransferBoardEntity;
import com.transfer.room.transferboard.mapper.TransferBoardMapper;
import com.transfer.room.transferboard.service.TransferBoardFileService;
import com.transfer.room.transferboard.service.TransferBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TransferBoardServiceImpl implements TransferBoardService {

    //롬복을 이용하여 생성자 주입
    private final TransferBoardMapper transferBoardMapper;
    private final TransferBoardFileService transferBoardFileService;

    @Override
    @Transactional(readOnly = true)
    public List<TransferBoardDetails> findTransferBoard(TransferBoardSearchFilter searchFilter) {
        List<TransferBoardDetails> transferBoardDetailList = transferBoardMapper.selectTransferBoard(searchFilter);
        for(TransferBoardDetails transferBoardDetails : transferBoardDetailList){
            int transferBoardId = transferBoardDetails.getTransferBoardId();
            List<TransferBoardFileDto> imageFiles = transferBoardFileService.selectTransferBoardImageFilesByTransferBoardId(transferBoardId);
            transferBoardDetails.setImgFileList(imageFiles);

            List<TransferBoardFileDto> attachments = transferBoardFileService.selectTransferBoardAttachmentFilesByTransferBoardId(transferBoardId);
            transferBoardDetails.setAttachedFileList(attachments);
        }

        return transferBoardDetailList;
    }

    @Override
    @Transactional(readOnly = false)
    public boolean addTransferBoard(TransferBoardDto transferBoardDto, List<MultipartFile> boardFiles) throws Exception {
        TransferBoardEntity transferBoardEntity = TransferBoardEntity.toTransferBoardDto(transferBoardDto);
        transferBoardMapper.insertTransferBoard(transferBoardEntity);
        int fileInsertCnt = 0;
        for(MultipartFile boardFile : boardFiles){
            TransferBoardFileDto fileDto = new TransferBoardFileDto();
            int tbId = transferBoardEntity.getTbId();
            fileDto.setTbId(tbId);
            fileInsertCnt++;
            transferBoardFileService.insertTransferBoardFile(fileDto, boardFile);
        }
        return fileInsertCnt == boardFiles.size();
    }

    @Override
    @Transactional(readOnly = false)
    public boolean modifyTransferBoard(TransferBoardDto transferBoardDto, List<MultipartFile> boardFiles) throws Exception {
        return false;
    }

    @Override
    @Transactional(readOnly = false)
    public boolean modifyTransferBoardTransferee(int transferBoardId, int transfereeId) throws Exception {
        int modifyCnt = transferBoardMapper.updateTransferBoardTransferee(transferBoardId, transfereeId);
        boolean isModified = (modifyCnt != 0);
        return isModified;
    }

    @Override
    public boolean modifyTransferBoardTransferStatus(int transferBoardId) throws Exception {
        int modifyCnt = transferBoardMapper.updateTransferBoardTransferStatus(transferBoardId);
        boolean isModified = (modifyCnt != 0);
        return isModified;
    }
}
