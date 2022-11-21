package com.transfer.room.transferboard.service.impl;

import com.transfer.room.transferboard.dto.TransferBoardFileDto;
import com.transfer.room.transferboard.entity.TransferBoardFileEntity;
import com.transfer.room.transferboard.mapper.TransferBoardFileMapper;
import com.transfer.room.transferboard.service.TransferBoardFileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TransferBoardFileServiceImpl implements TransferBoardFileService {
    @Value("${spring.servlet.multipart.location}")
    private String uploadFIlePath;
    private final TransferBoardFileMapper transferBoardFileMapper;
    public TransferBoardFileServiceImpl(TransferBoardFileMapper transferBoardFileMapper){
        this.transferBoardFileMapper = transferBoardFileMapper;
    }

    private String getRealFileName(MultipartFile file) {
        String today = new SimpleDateFormat("yyMMdd-HHmmss").format(new Date());
        String originalFileName = file.getOriginalFilename();
        System.out.println(originalFileName);
        String baseName = originalFileName.split("\\.")[0];
        String extension = originalFileName.split("\\.")[1];
        return baseName + "-" + today + "." + extension;
    }
    private String saveFile(MultipartFile file) throws IOException{
        System.out.println(uploadFIlePath);
        File saveDir = new File(uploadFIlePath);
        if (!saveDir.exists()) saveDir.mkdirs();
        String realFileName = getRealFileName(file);
        File saveFile = new File(saveDir, realFileName);
        file.transferTo(saveFile);
        return saveDir + File.separator + realFileName;
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
    @Transactional(readOnly = false)
    public int insertTransferBoardFile(TransferBoardFileDto transferBoardFileDto, MultipartFile transferBoardFile) throws IOException {
        String realFilePath = saveFile(transferBoardFile);
        String fileContentType = transferBoardFile.getContentType();
        transferBoardFileDto.setFileContentType(fileContentType);
        transferBoardFileDto.setFilePath(realFilePath);

        int isAttachment = (fileContentType.contains("image")) ? 0 : 1;
        transferBoardFileDto.setIsAttachment(isAttachment);

        TransferBoardFileEntity transferBoardFileEntity = TransferBoardFileEntity.toTransferBoardFileDto(transferBoardFileDto);
        return transferBoardFileMapper.insertTransferBoardFile(transferBoardFileEntity);
    }

    @Override
    @Transactional(readOnly = false)
    public int modifyTransferBoardFile(TransferBoardFileDto transferBoardFileDto, MultipartFile transferBoardFile) {
        return 0;
    }
}
