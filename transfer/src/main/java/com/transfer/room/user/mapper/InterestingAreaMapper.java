package com.transfer.room.user.mapper;

import com.transfer.room.user.dto.InterestingAreaDetails;
import com.transfer.room.user.entity.InterestingAreaEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InterestingAreaMapper {
    List<InterestingAreaDetails> selectAllInterestingAreasDetails(int userId) throws Exception;  // 유저의 관심지역의 상제 정보 모두 조회
    InterestingAreaDetails selectInterestingAreaDetailById(int interestingAreaId, int userId) throws Exception; // 유저의 관심지역 상세 정보를 관심지역 id로 조회
    int deleteInterestingAreaById(int interestingAreaId, int userId) throws Exception; // 관심지역 삭제
    int insertInterestingArea(InterestingAreaEntity interestingAreaEntity) throws Exception; // 관심지역 추가
}
