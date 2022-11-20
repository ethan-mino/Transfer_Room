package com.transfer.room.user.controller;

import com.transfer.room.user.dto.CustomUserDetails;
import com.transfer.room.user.dto.InterestingAreaDetails;
import com.transfer.room.user.dto.InterestingAreaDto;
import com.transfer.room.user.service.InterestingAreaService;
import com.transfer.room.util.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController
public class InterestingController {
    private final InterestingAreaService interestingAreaService;

    public InterestingController(InterestingAreaService interestingAreaService){
        this.interestingAreaService = interestingAreaService;
    }

    @GetMapping("/interesting-area/{interestingAreaId}")
    public ResponseEntity<InterestingAreaDetails> interestingAreaDetailsById(
            @PathVariable(required = true) int interestingAreaId,
            @AuthenticationPrincipal CustomUserDetails loginUser){

        int loginUserId = loginUser.getUserId();
        try{
            InterestingAreaDetails interestingAreaDetails = interestingAreaService.findInterestingAreaDetailById(interestingAreaId, loginUserId);
            return ResponseEntity.ok(interestingAreaDetails);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/interesting-area")
    public ResponseEntity<ApiResponse<List<InterestingAreaDetails>>> interestingAreaList(@AuthenticationPrincipal CustomUserDetails loginUser){
        ApiResponse<List<InterestingAreaDetails>> apiResponse = new ApiResponse<>();

        int loginUserId = loginUser.getUserId();

        try{
            List<InterestingAreaDetails> interestingAreaList = interestingAreaService.findAllInterestingAreasDetails(loginUserId);
            apiResponse.setData(interestingAreaList);
            return ResponseEntity.ok(apiResponse);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/interesting-area")
    public ResponseEntity interestingAreaAdd(   // TODO : 상태코드만 반환하는 controller의 제네릭 파라미터는 어떻게할 것인지 상의
            @RequestBody InterestingAreaDto interestingAreaDto,
            @AuthenticationPrincipal CustomUserDetails loginUser){
        int loginUserId = loginUser.getUserId();
        interestingAreaDto.setUserId(loginUserId);

        try{
            boolean isInterestingAreaAdded = interestingAreaService.addInterestingArea(interestingAreaDto);
            if(isInterestingAreaAdded){
                return ResponseEntity.ok().build();
            }else{
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/interesting-area/{id}")
    public ResponseEntity interestingAreaRemoveById(
            @PathVariable(required = true, name = "id") int interestingAreaId,
            @AuthenticationPrincipal CustomUserDetails loginUser){

        int loginUserId = loginUser.getUserId();

        try{
            boolean isInterestingAreaDeleted = interestingAreaService.removeInterestingAreaById(interestingAreaId, loginUserId);
            if(isInterestingAreaDeleted){
                return ResponseEntity.ok().build();
            }else{
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
