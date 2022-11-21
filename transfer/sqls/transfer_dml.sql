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
INSERT INTO transfer_boards(transferer_id,transferee_id,transfer_status,tb_title,tb_content,tb_create_time,tb_update_time,room_latitude,room_longitude, room_address, room_floor, room_type, contract_type,contract_end_time,dongCode,like_count,approving_status)
VALUE (1,null,0,'test Title','test content',now(),now(),13.777777,13.888888,'대전 유성구',5,'원룸','월세',date('2022-11-19'),'1111010100',0,1);

INSERT INTO transfer_boards(transferer_id,transferee_id,transfer_status,tb_title,tb_content,tb_create_time,tb_update_time,room_latitude,room_longitude, room_address, room_floor, room_type, contract_type,contract_end_time,dongCode,like_count,approving_status)
VALUE (1,null,0,'test Title2','test content2',now(),now(),15.777777,16.888888,'대전 유성구',5,'투룸','전세',date('2022-11-18'),'1111010100',0,2);

INSERT INTO transfer_boards(transferer_id,transferee_id,transfer_status,tb_title,tb_content,tb_create_time,tb_update_time,room_latitude,room_longitude, room_address, room_floor, room_type, contract_type,contract_end_time,dongCode,like_count,approving_status)
VALUE (1,null,0,'test Title3','test content3',now(),now(),133.777777,336.888888,'대전 중구',6,'쓰리룸','전세',date('2022-11-18'),'1111010100',2,0);

INSERT INTO transfer_boards(transferer_id,transferee_id,transfer_status,tb_title,tb_content,tb_create_time,tb_update_time,room_latitude,room_longitude, room_address, room_floor, room_type, contract_type,contract_end_time,dongCode,like_count,approving_status)
VALUE (1,null,0,'test Title4','test content3',now(),now(),133.777777,336.888888,'대전 중구',6,'쓰리룸','전세',date('2022-11-18'),'1111010100',2,1);


INSERT INTO transfer_boards(transferer_id,transferee_id,transfer_status,tb_title,tb_content,tb_create_time,tb_update_time,room_latitude,room_longitude, room_address, room_floor, room_type, contract_type,contract_end_time,dongCode,like_count,approving_status)
VALUE (2,null,0,'test Title5','test content3',now(),now(),133.777777,336.888888,'대전 중구',6,'쓰리룸','전세',date('2022-11-18'),'1111010100',2,1);

INSERT INTO transfer_boards(transferer_id,transferee_id,transfer_status,tb_title,tb_content,tb_create_time,tb_update_time,room_latitude,room_longitude, room_address, room_floor, room_type, contract_type,contract_end_time,dongCode,like_count,approving_status)
VALUE (2,null,0,'test Title6','test content3',now(),now(),133.777777,336.888888,'대전 중구',6,'쓰리룸','전세',date('2022-11-18'),'1111010100',2,1);

-- -----------------------------------------------------
-- Table `transfer_dev`.`transfer_board_files`
-- -----------------------------------------------------
INSERT INTO transfer_board_files(tb_id,file_path, file_content_type,is_attachment)
    VALUE (1,'/user/lsh9672/img1.png','image/png', 0);

INSERT INTO transfer_board_files(tb_id,file_path, file_content_type,is_attachment)
    VALUE (1,'/user/lsh9672/img2.png','image/jpg', 0);

INSERT INTO transfer_board_files(tb_id,file_path, file_content_type,is_attachment)
    VALUE (1,'/user/lsh9672/contract.pdf','application/pdf', 1);

INSERT INTO transfer_board_files(tb_id,file_path, file_content_type,is_attachment)
    VALUE (2,'/user/lsh9672/contract.pdf','application/pdf', 1);

-- -----------------------------------------------------
-- Table `transfer_dev`.`interesting_area`
-- -----------------------------------------------------
INSERT INTO interesting_areas(ia_id, user_id, dongCode, ia_create_time) VALUES (1, 3, '1111014700', now());
INSERT INTO interesting_areas(ia_id, user_id, dongCode, ia_create_time) VALUES (2, 4, '1111014600', now());
INSERT INTO interesting_areas(ia_id, user_id, dongCode, ia_create_time) VALUES (3, 4, '1111013400', now());
INSERT INTO interesting_areas(ia_id, user_id, dongCode, ia_create_time) VALUES (4, 4, '1111010200', now());
INSERT INTO interesting_areas(ia_id, user_id, dongCode, ia_create_time) VALUES (5, 4, '1111010600', now());

