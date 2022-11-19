package com.transfer.room.region.controller;


import com.transfer.room.region.dto.DongNameDto;
import com.transfer.room.region.dto.GugunNameDto;
import com.transfer.room.region.dto.RegionDto;
import com.transfer.room.region.dto.SidoNameDto;
import com.transfer.room.region.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/region")
public class RegionController {

    // TODO: 2022-11-19 각 컨트롤러에서 예외를 잡아서 처리하는데, 나중에 ControllerAdvice로 처리
    private final RegionService regionService;


    @GetMapping("/sido")
    public ResponseEntity<?> getAllSido() {

        List<SidoNameDto> sidoNameDtos = null;

        try {
            sidoNameDtos = regionService.findAllSido();

            if(sidoNameDtos == null) {
                return ResponseEntity.noContent().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

        return ResponseEntity.ok(sidoNameDtos);
    }

    @GetMapping("/gugun")
    public ResponseEntity<?> getAllGugunBySidoCode(@RequestParam String sidoCode) {

        List<GugunNameDto> gugunNameDtos = null;
        try {
            gugunNameDtos = regionService.findAllGugunBySidoCode(sidoCode);

            if(gugunNameDtos == null){
                return ResponseEntity.noContent().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

        return ResponseEntity.ok(gugunNameDtos);
    }

    @GetMapping("/dong")
    public ResponseEntity<?> getAllDongByGugunCode(@RequestParam String gugunCode){

        List<DongNameDto> dongNameDtos = null;

        try {
            dongNameDtos = regionService.findAllDongByGugunCode(gugunCode);

            if(dongNameDtos == null){
                return ResponseEntity.noContent().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

        return ResponseEntity.ok(dongNameDtos);
    }

    @GetMapping("/dong/{dongCode}")
    public ResponseEntity<?> getDongByDongCode(@PathVariable("dongCode") String dongCode){

        RegionDto allDongByDongCode = null;
        try {
            allDongByDongCode = regionService.findAllDongByDongCode(dongCode);
            if(allDongByDongCode == null){
                return ResponseEntity.noContent().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

        return ResponseEntity.ok(allDongByDongCode);
    }
}
