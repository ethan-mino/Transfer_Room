-- -----------------------------------------------------
-- Table `transfer_dev`.`users`
-- -----------------------------------------------------

INSERT INTO users(user_id, user_name,user_email, user_password, user_address, user_create_time, user_update_time)
    VALUE (1, '이상현','lsh80165@gmail.com','$2a$10$cXTmQ4l6civQlxvj7bkvD.I7vhPyJLBM.oPlStfFa104XDXSRSCbq', '대전', now(), now());

INSERT INTO users(user_id, user_name,user_email, user_password, user_address, user_create_time, user_update_time)
    VALUE (2, '이상현2','lsh80165@naver.com','$2a$10$cXTmQ4l6civQlxvj7bkvD.I7vhPyJLBM.oPlStfFa104XDXSRSCbq', '서울', now(), now());

INSERT INTO users(user_id, user_name,user_email, user_password, user_address, user_create_time, user_update_time)
    VALUE (3, '길민호','rlfalsgh95@naver.com','$2a$10$cXTmQ4l6civQlxvj7bkvD.I7vhPyJLBM.oPlStfFa104XDXSRSCbq', '용인', now(), now());

INSERT INTO users(user_id, user_name,user_email, user_password, user_address, user_create_time, user_update_time)
    VALUE (4, 'test','test@naver.com','$2a$10$cXTmQ4l6civQlxvj7bkvD.I7vhPyJLBM.oPlStfFa104XDXSRSCbq', '용인', now(), now());


-- -----------------------------------------------------
-- Table `transfer_dev`.`roles`
-- -----------------------------------------------------
INSERT INTO roles(role_id, role_name) VALUES (1, 'ROLE_USER');
INSERT INTO roles(role_id, role_name) VALUES (2, 'ROLE_ADMIN');

-- -----------------------------------------------------
-- Table `transfer_dev`.`users`
-- -----------------------------------------------------
INSERT INTO user_roles(user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles(user_id, role_id) VALUES (2, 1);
INSERT INTO user_roles(user_id, role_id) VALUES (3, 1);
INSERT INTO user_roles(user_id, role_id) VALUES (4, 1);


-- -----------------------------------------------------
-- Table `transfer_dev`.`transfer_boards`
-- -----------------------------------------------------
INSERT INTO transfer_boards(tb_id, transferer_id,transferee_id,transfer_status,tb_title,tb_content,tb_create_time,tb_update_time,room_latitude,room_longitude, room_address, room_floor, room_type, contract_type,contract_end_time,dongCode,like_count,approving_status)
VALUE (1, 1,null,0,'충남대역 근처 원룸 양도합니다!','★ 매물위치 ★

궁동 충남대 정문앞 스타벅스뒷편

★ 매물특징 ★

1) 주방분리형의 혼자 살기 적당한 크기의 원룸

2) 넓은 베란다가 있어 활용도가 좋음

3) 붙박이장으로 되어 있어 공간활용 좋음

4) 넓은 주차장이 있어 주차용이함

5) 건물 내,외부 관리 상태는 굿~~ .

6) 현관,방 번호키 CCTV 有 보안철저 .

7) 편의시설(편의점.커피숍.빨래방.헬스장등)이 잘 되어 있어 생활이 편리함

8) 관리비(인터넷.유선포함) 10만원에 공과금(전기.가스.수도)만 쓰신만큼~~

9) 충대정문버스정류장과 유성온천역이 있어 교통이편리함.

10) 소방안전시설과 엘리베이터가 있음',now(),now(),36.3611679,127.3456011,'대전시 유성구 궁동',5,'원룸','월세',date('2022-11-19'),'3020012200',32,1);

INSERT INTO transfer_board_files(file_id, tb_id,file_path, file_content_type,is_attachment)
    VALUE (1, 1,'c:/uploads/room_1.jpg','image/jpeg', 0);

INSERT INTO transfer_board_files(file_id, tb_id,file_path, file_content_type,is_attachment)
    VALUE (2, 1,'c:/uploads/room_2.jpg','image/jpeg', 0);

INSERT INTO transfer_board_files(file_id, tb_id,file_path, file_content_type,is_attachment)
    VALUE (3, 1,'c:/uploads/room_3.jpg','image/jpeg', 0);

INSERT INTO transfer_board_files(file_id, tb_id,file_path, file_content_type,is_attachment)
    VALUE (4, 1,'c:/uploads/임대인_양도_동의서.pdf','application/pdf', 1);



INSERT INTO transfer_boards(tb_id, transferer_id,transferee_id,transfer_status,tb_title,tb_content,tb_create_time,tb_update_time,room_latitude,room_longitude, room_address, room_floor, room_type, contract_type,contract_end_time,dongCode,like_count,approving_status)
    VALUE (2, 1,null,0,'New신축급❤공과금모두무료❤밝고환해요','☘리모델링 신축방이라서 내부 완전깨끗해요
☘충대까지 3분거리
☘방안에 수납공간들이 엄청 많아서 좋아요
☘공과금모두포함 깨끗한방으로 찾고계신다면 추천
☘현관&층마다 CCTV설치 대로변에 가까워서 24시간 안전
☘공과금 ✔모두무료(수도,전기,가스비 모두무료)
☘남향이라 밝고 채광좋아요
☘창문이 커서 환기까지 아주 잘된답니다


❤공과금 ✔모두무료(수도,전기,가스비 모두무료)
❤기간조절가능


☘옵션 :
에어컨, 냉장고, 인덕션, 드럼세탁기, 전자레인지
TV, 침대, 책상, 의자, 옷장, 번호키, 정수기
인터넷, 유선 등 ',now(),now(),36.3612384,127.3421819,'대전시 유성구 궁동',5,'투름','전세',date('2022-11-19'),'3020012200',24,1);

INSERT INTO transfer_board_files(file_id, tb_id,file_path, file_content_type,is_attachment)
    VALUE (5, 2,'c:/uploads/room_4.jpg','image/jpeg', 0);

INSERT INTO transfer_board_files(file_id, tb_id,file_path, file_content_type,is_attachment)
    VALUE (6, 2,'c:/uploads/room_5.jpg','image/jpeg', 0);

INSERT INTO transfer_board_files(file_id, tb_id,file_path, file_content_type,is_attachment)
    VALUE (7, 2,'c:/uploads/room_6.png','image/png', 0);

INSERT INTO transfer_board_files(file_id, tb_id,file_path, file_content_type,is_attachment)
    VALUE (8, 2,'c:/uploads/임대인_양도_동의서.pdf','application/pdf', 1);

-- -----------------------------------------------------
-- Table `transfer_dev`.`transfer_board_files`
-- -----------------------------------------------------


-- -----------------------------------------------------
-- Table `transfer_dev`.`interesting_area`
-- -----------------------------------------------------
INSERT INTO interesting_areas(ia_id, user_id, dongCode, ia_create_time) VALUES (1, 1, '1111014700', now());
INSERT INTO interesting_areas(ia_id, user_id, dongCode, ia_create_time) VALUES (2, 1, '1111014600', now());
INSERT INTO interesting_areas(ia_id, user_id, dongCode, ia_create_time) VALUES (3, 1, '1111013400', now());
INSERT INTO interesting_areas(ia_id, user_id, dongCode, ia_create_time) VALUES (4, 1, '1111010200', now());
INSERT INTO interesting_areas(ia_id, user_id, dongCode, ia_create_time) VALUES (5, 1, '1111010600', now());

