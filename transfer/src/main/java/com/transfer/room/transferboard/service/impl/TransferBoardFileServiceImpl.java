package com.transfer.room.transferboard.service.impl;

import com.transfer.room.transferboard.dto.TransferBoardFileDto;
import com.transfer.room.transferboard.entity.TransferBoardFileEntity;
import com.transfer.room.transferboard.mapper.TransferBoardFileMapper;
import com.transfer.room.transferboard.service.TransferBoardFileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static com.transfer.room.util.FileUtil.saveFile;

@Service
public class TransferBoardFileServiceImpl implements TransferBoardFileService {
    @Value("${spring.servlet.multipart.location}")
    private String uploadFIlePath;
    private final TransferBoardFileMapper transferBoardFileMapper;
    public TransferBoardFileServiceImpl(TransferBoardFileMapper transferBoardFileMapper){
        this.transferBoardFileMapper = transferBoardFileMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TransferBoardFileDto> selectTransferBoardImageFilesByTransferBoardId(int transferBoardId) {
        return transferBoardFileMapper.selectTransferBoardImageFilesByTransferBoardId(transferBoardId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TransferBoardFileDto> selectTransferBoardAttachmentFilesByTransferBoardId(int transferBoardId) {
        return transferBoardFileMapper.selectTransferBoardAttachmentFilesByTransferBoardId(transferBoardId);
    }

    @Override
    public TransferBoardFileDto selectTransferBoardAttachmentFileByTransferBoardFileId(int transferBoardFileId) {
        return transferBoardFileMapper.selectTransferBoardAttachmentFileByTransferBoardFileId(transferBoardFileId);
    }

    @Override
    @Transactional(readOnly = false)
    public boolean insertTransferBoardFile(TransferBoardFileDto transferBoardFileDto, MultipartFile transferBoardFile) throws IOException {
        String realFilePath = saveFile(transferBoardFile, uploadFIlePath);
        String fileContentType = transferBoardFile.getContentType();
        transferBoardFileDto.setFileContentType(fileContentType);
        transferBoardFileDto.setFilePath(realFilePath);

        int isAttachment = (fileContentType.contains("image")) ? 0 : 1;
        transferBoardFileDto.setIsAttachment(isAttachment);

        TransferBoardFileEntity transferBoardFileEntity = TransferBoardFileEntity.toTransferBoardFileDto(transferBoardFileDto);
        int transferBoardFileInsertCnt = transferBoardFileMapper.insertTransferBoardFile(transferBoardFileEntity);
        boolean isTransferBoardFileAdded = (transferBoardFileInsertCnt == 0);
        return isTransferBoardFileAdded;
    }

    @Override
    @Transactional(readOnly = false)
    public boolean modifyTransferBoardFile(TransferBoardFileDto transferBoardFileDto, MultipartFile transferBoardFile) {
        return true;
    }
}
