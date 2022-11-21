package com.transfer.room.transferboard.controller;


import com.transfer.room.transferboard.service.TransferBoardFileService;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TransferBoardFileController {
	private final TransferBoardFileService transferBoardFileService;
	public TransferBoardFileController(TransferBoardFileService transferBoardFileService){
		this.transferBoardFileService = transferBoardFileService;
	}
}
