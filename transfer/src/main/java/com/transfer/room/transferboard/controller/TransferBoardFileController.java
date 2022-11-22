package com.transfer.room.transferboard.controller;


import com.transfer.room.transferboard.dto.TransferBoardFileDto;
import com.transfer.room.transferboard.service.TransferBoardFileService;
import com.transfer.room.user.dto.CustomUserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

import static com.transfer.room.util.FileUtil.sendFile;


@RestController
public class TransferBoardFileController {
	private final TransferBoardFileService transferBoardFileService;
	public TransferBoardFileController(TransferBoardFileService transferBoardFileService){
		this.transferBoardFileService = transferBoardFileService;
	}

	@GetMapping("/transfer-board/file/{fileId}")
	public void fileDownload(@PathVariable("fileId") int fileId,
							 HttpServletResponse response,
							 @AuthenticationPrincipal CustomUserDetails loginUser){
		TransferBoardFileDto fileInfoDto = transferBoardFileService.selectTransferBoardAttachmentFileByTransferBoardFileId(fileId);   // fileId로 첨부 파일 정보 조회

		if(fileInfoDto != null){
			String filePath = fileInfoDto.getFilePath();
			String contentType = fileInfoDto.getFileContentType();

			// TODO : 파일이 존재하지 않을 때 처리
			sendFile(response, contentType, filePath);    // 요청한 파일 전송
		}else{
			// TODO : 요청한 파일이 없을 때 처리
		}
	}
}
