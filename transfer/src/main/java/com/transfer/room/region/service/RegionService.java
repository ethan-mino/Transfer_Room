package com.transfer.room.region.service;

import com.transfer.room.region.dto.DongNameDto;
import com.transfer.room.region.dto.GugunNameDto;
import com.transfer.room.region.dto.RegionDto;
import com.transfer.room.region.dto.SidoNameDto;

import java.util.List;

public interface RegionService {
    List<SidoNameDto> findAllSido() throws Exception;
    List<GugunNameDto> findAllGugunBySidoCode(String sidoCode) throws Exception;
    List<DongNameDto> findAllDongByGugunCode(String gugunCode) throws Exception;
    RegionDto findAllDongByDongCode(String dongCode) throws Exception;

}
