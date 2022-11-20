package com.transfer.room;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

/*
	* TODO : 코딩 컨벤션 작성 (git, mapper, 변수/method명, 파라미터 전달 ...)
	* TODO : 특정 도메인의 값인지 확인하는 로직 또는 코드 추가 (ex. 방 계약 종류)
	* TODO : SELECT도 Exception 발생할 수 있음 처리 (ex. timeout)
	* TODO : 보안 관련 파일 ignore
	* TODO : service, mapper로 파라미터 전달 할 때, DTO 사용할 지 상의 (select, delete 시)
	* TODO : Controller Advice 적용
	* TODO : JUnit을 이용한 테스트 코드 작성
	* TODO : REST API 서버의 응답 통일 (ex. insert 성공 시, 어떤 데이터를 내려줄지)
 */
@SpringBootApplication
@ConfigurationPropertiesScan
public class TransferApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransferApplication.class, args);
	}

}
