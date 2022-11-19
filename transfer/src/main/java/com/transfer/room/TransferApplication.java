package com.transfer.room;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

/*
	* TODO : 특정 도메인의 값인지 확인하는 로직 또는 코드 추가 (ex. 방 계약 종류)
	* TODO : SELECT도 Exception 발생할 수 있음 처리 (ex. timeout)
	* TODO : 보안 데이터 ignore
 */
@SpringBootApplication
@ConfigurationPropertiesScan
public class TransferApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransferApplication.class, args);
	}

}
