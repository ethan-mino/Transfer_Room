package com.transfer.room.transferboard.controller;

import com.transfer.room.transferboard.dto.TransferBoardDto;
import com.transfer.room.transferboard.dto.TransferBoardListDto;
import com.transfer.room.transferboard.service.TransferBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/transferBoard")
public class TransferBoardController {

    private final TransferBoardService transferBoardService;


    @GetMapping("/board/{articleId}")
    public ResponseEntity<?> selectArticle(@PathVariable("articleId") int articleId){

        TransferBoardDto apiResponse = transferBoardService.findTransferBoardByArticleId(articleId);

        //데이터가 없다면 204(No Content를 반한다.)
        if(apiResponse == null){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/boards/{dongCode}")
    public ResponseEntity<?> selectArticleList(@PathVariable("dongCode") String dongCode){

        List<TransferBoardListDto> apiResponse = transferBoardService.findTransferBoardByDongCode(dongCode);

        if(apiResponse == null){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(apiResponse);
    }


}
