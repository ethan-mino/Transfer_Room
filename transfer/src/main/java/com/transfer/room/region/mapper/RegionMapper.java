package com.transfer.room.region.mapper;


import com.transfer.room.region.dto.DongNameDto;
import com.transfer.room.region.dto.GugunNameDto;
import com.transfer.room.region.dto.RegionDto;
import com.transfer.room.region.dto.SidoNameDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface RegionMapper {

    List<SidoNameDto> findAllSido() throws Exception;
    List<GugunNameDto> findAllGugunBySidoCode(String sidoCode) throws Exception;
    List<DongNameDto> findAllDongByGugunCode(String gugunCode) throws Exception;
    RegionDto findAllDongByDongCode(String dongCode) throws Exception;

}
