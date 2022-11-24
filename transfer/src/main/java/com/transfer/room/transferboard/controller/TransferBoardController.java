package com.transfer.room.transferboard.controller;

import com.transfer.room.transferboard.dto.TransferBoardDetails;
import com.transfer.room.transferboard.dto.TransferBoardDto;
import com.transfer.room.transferboard.dto.TransferBoardSearchFilter;
import com.transfer.room.transferboard.dto.TransferBoardStatus;
import com.transfer.room.transferboard.service.TransferBoardService;
import com.transfer.room.user.dto.CustomUserDetails;
import com.transfer.room.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/transfer-board")
public class TransferBoardController {
    // TODO : 양수인, 양도인 외의 유저는 양도 게시글의 상태를 알 수 없도록 해야함 (searchFilter를 사용하는 경우, 해당 데이터에 대한 권한을 체크하기 어려움)
    private final TransferBoardService transferBoardService;

    @GetMapping("/approved")
    public ResponseEntity<ApiResponse<List<TransferBoardDetails>>> approvedTransferBoardDetails(
            @RequestParam(value = "transferBoardId", required = false) Integer transferBoardId,
            @RequestParam(value = "dongCode", required = false) String dongCode){
        TransferBoardSearchFilter searchFilter = new TransferBoardSearchFilter();
        searchFilter.setApprovingStatus(TransferBoardStatus.APPROVED.getValue());
        if(transferBoardId != null) searchFilter.setTransferBoardId(transferBoardId);
        if(dongCode != null) searchFilter.setDongCode(dongCode);

        List<TransferBoardDetails> transferBoardDetails = transferBoardService.findTransferBoard(searchFilter);

        //데이터가 없다면 204(No Content를 반한다.)
        if(transferBoardDetails == null){
            return ResponseEntity.noContent().build();
        }

        ApiResponse<List<TransferBoardDetails>> apiResponse = new ApiResponse<>();
        apiResponse.setData(transferBoardDetails);

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{userEmail}")
    public ResponseEntity<?> transferBoardDetailsByUserEmail
            (@PathVariable("userEmail") String userEmail){
        System.out.println("test : " + userEmail);
        TransferBoardSearchFilter searchFilter = new TransferBoardSearchFilter();
        searchFilter.setUserEmail(userEmail);
        searchFilter.setMyPageStatus(1);

        // TODO : 본인의 양도 게시글이 아니라면 조회할 수 없도록 해야함
        List<TransferBoardDetails> transferBoardDetails = transferBoardService.findTransferBoard(searchFilter);
        ApiResponse<List<TransferBoardDetails>> apiResponse = new ApiResponse<>();
        apiResponse.setData(transferBoardDetails);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/most-likes")
    public ResponseEntity<?> MostLikesTransferBoardDetails(
            @RequestParam(value = "numOfRows", required = true) int numOfRows){

        TransferBoardSearchFilter searchFilter = new TransferBoardSearchFilter();
        searchFilter.setApprovingStatus(TransferBoardStatus.APPROVED.getValue());
        searchFilter.setNumOfRows(numOfRows);
        searchFilter.setOrder("likes");

        // TODO : 본인의 양도 게시글이 아니라면 조회할 수 없도록 해야함
        List<TransferBoardDetails> transferBoardDetails = transferBoardService.findTransferBoard(searchFilter);
        ApiResponse<List<TransferBoardDetails>> apiResponse = new ApiResponse<>();
        apiResponse.setData(transferBoardDetails);
        return ResponseEntity.ok(apiResponse);
    }

    //시간순으로 정렬
    @GetMapping("/last-time")
    public ResponseEntity<?> LastTimeTransferBoardDetails(
            @RequestParam(value = "numOfRows", required = true) int numOfRows){

        TransferBoardSearchFilter searchFilter = new TransferBoardSearchFilter();
        searchFilter.setApprovingStatus(TransferBoardStatus.APPROVED.getValue());
        searchFilter.setNumOfRows(numOfRows);
        searchFilter.setOrder("likes");

        // TODO : 본인의 양도 게시글이 아니라면 조회할 수 없도록 해야함
        List<TransferBoardDetails> transferBoardDetails = transferBoardService.findTransferBoard(searchFilter);
        ApiResponse<List<TransferBoardDetails>> apiResponse = new ApiResponse<>();
        apiResponse.setData(transferBoardDetails);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/most-likes/{dongCode}")
    public ResponseEntity<?> MostLikesTransferBoardDetailsByDongCode(
            @PathVariable("dongCode") String dongCode,
            @RequestParam(value = "numOfRows", required = true) int numOfRows){

        TransferBoardSearchFilter searchFilter = new TransferBoardSearchFilter();
        searchFilter.setApprovingStatus(TransferBoardStatus.APPROVED.getValue());
        searchFilter.setNumOfRows(numOfRows);
        searchFilter.setOrder("likes");
        searchFilter.setDongCode(dongCode);

        // TODO : 본인의 양도 게시글이 아니라면 조회할 수 없도록 해야함
        List<TransferBoardDetails> transferBoardDetails = transferBoardService.findTransferBoard(searchFilter);
        ApiResponse<List<TransferBoardDetails>> apiResponse = new ApiResponse<>();
        apiResponse.setData(transferBoardDetails);
        return ResponseEntity.ok(apiResponse);
    }


    @GetMapping("/pending")
    public ResponseEntity<?> pendingTransferBoardDetailsByDongCode(){
        TransferBoardSearchFilter searchFilter = new TransferBoardSearchFilter();
        searchFilter.setApprovingStatus(TransferBoardStatus.PENDING.getValue());

        List<TransferBoardDetails> transferBoardDetails = transferBoardService.findTransferBoard(searchFilter);
        ApiResponse<List<TransferBoardDetails>> apiResponse = new ApiResponse<>();
        apiResponse.setData(transferBoardDetails);
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/{transferBoardId}")
    public ResponseEntity<?> transferBoardModiFyTransferee(
            @PathVariable(value = "transferBoardId") int transferBoardId,
            @AuthenticationPrincipal CustomUserDetails loginUser){

        int transfereeId = loginUser.getUserId();

        try{
            transferBoardService.modifyTransferBoardTransferee(transferBoardId, transfereeId);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> transferBoardAdd(
            @RequestPart("data") TransferBoardDto transferBoardDto,
            @RequestPart(value = "uploadFile", required = false) List<MultipartFile> boardFiles,
            @AuthenticationPrincipal CustomUserDetails loginUser){

        System.out.println(transferBoardDto);
        System.out.println("test : " + boardFiles.size());
        int loginUserId = loginUser.getUserId();
        transferBoardDto.setTransfererId(loginUserId);

        try{
            transferBoardService.addTransferBoard(transferBoardDto, boardFiles);    // TODO : 파일 저장도 service 내에서 수행
            return ResponseEntity.ok().build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/status/{transferBoardId}")
    public ResponseEntity<?> transferBoardModiFyTransferStatus(
            @PathVariable(value = "transferBoardId") int transferBoardId,
            @AuthenticationPrincipal CustomUserDetails loginUser){

        System.out.println("tesrse");
//        int transfereeId = loginUser.getUserId();
        try{
            transferBoardService.modifyTransferBoardTransferStatus(transferBoardId);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }


}
