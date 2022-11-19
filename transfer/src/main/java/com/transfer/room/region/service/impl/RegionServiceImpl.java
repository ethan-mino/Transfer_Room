package com.transfer.room.region.service.impl;

import com.transfer.room.region.dto.DongNameDto;
import com.transfer.room.region.dto.GugunNameDto;
import com.transfer.room.region.dto.RegionDto;
import com.transfer.room.region.dto.SidoNameDto;
import com.transfer.room.region.mapper.RegionMapper;
import com.transfer.room.region.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RegionServiceImpl implements RegionService {

    private final RegionMapper regionMapper;

    @Override
    public List<SidoNameDto> findAllSido() throws Exception {
        return regionMapper.findAllSido();
    }

    @Override
    public List<GugunNameDto> findAllGugunBySidoCode(String sidoCode) throws Exception {
        return regionMapper.findAllGugunBySidoCode(sidoCode);
    }

    @Override
    public List<DongNameDto> findAllDongByGugunCode(String gugunCode) throws Exception {
        return regionMapper.findAllDongByGugunCode(gugunCode);
    }

    @Override
    public RegionDto findAllDongByDongCode(String dongCode) throws Exception {
        return regionMapper.findAllDongByDongCode(dongCode);
    }
}
