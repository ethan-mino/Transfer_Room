package com.transfer.room.user.service;

import com.transfer.room.user.dto.InterestingAreaDetails;
import com.transfer.room.user.dto.InterestingAreaDto;

import java.util.List;

public interface InterestingAreaService {
    List<InterestingAreaDetails> findAllInterestingAreasDetails(int userId) throws Exception;  // 유저의 관심지역의 상제 정보 모두 조회
    InterestingAreaDetails findInterestingAreaDetailById(int interestingAreaId, int userId) throws Exception; // 유저의 관심지역 상세 정보를 관심지역 id로 조회
    boolean removeInterestingAreaById(int interestingAreaId, int userId) throws Exception; // 관심지역 삭제
    boolean addInterestingArea(InterestingAreaDto interestingAreaDto) throws Exception; // 관심지역 추가
}
