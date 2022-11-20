package com.transfer.room.user.service.impl;

import com.transfer.room.user.dto.InterestingAreaDetails;
import com.transfer.room.user.dto.InterestingAreaDto;
import com.transfer.room.user.entity.InterestingAreaEntity;
import com.transfer.room.user.mapper.InterestingAreaMapper;
import com.transfer.room.user.service.InterestingAreaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InterestingServiceImpl  implements InterestingAreaService {
    private final InterestingAreaMapper interestingAreaMapper;
    
    public InterestingServiceImpl(InterestingAreaMapper interestingAreaMapper){
        this.interestingAreaMapper = interestingAreaMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<InterestingAreaDetails> findAllInterestingAreasDetails(int userId) throws Exception {
        return interestingAreaMapper.selectAllInterestingAreasDetails(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public InterestingAreaDetails findInterestingAreaDetailById(int interestingAreaId, int userId) throws Exception {
        return interestingAreaMapper.selectInterestingAreaDetailById(interestingAreaId, userId);
    }

    @Override
    @Transactional(readOnly = false)
    public boolean removeInterestingAreaById(int interestingAreaId, int userId) throws Exception {
        int interestingAreaDeleteCnt = interestingAreaMapper.deleteInterestingAreaById(interestingAreaId, userId);

        // TODO : 본인의 관심지역만 삭제할 수 있도록 수정
        boolean isInterestingAreaDeleted = (interestingAreaDeleteCnt == 1);
        return isInterestingAreaDeleted;
    }

    @Override
    @Transactional(readOnly = false)
    public boolean addInterestingArea(InterestingAreaDto interestingAreaDto) throws Exception {
        InterestingAreaEntity interestingAreaEntity = InterestingAreaEntity.toInterestingAreaDto(interestingAreaDto);

        // TODO : 동일한 관심지역은 등록하지 못하도록 수정
        int interestingAreaAddCnt = interestingAreaMapper.insertInterestingArea(interestingAreaEntity);
        boolean isInterestingAreaAdded = (interestingAreaAddCnt == 1);
        return isInterestingAreaAdded;
    }
}
