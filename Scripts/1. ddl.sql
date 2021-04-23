drop table if exists web_gradle_erp.board;

create table if not exists web_gradle_erp.board(
	BOARD_NUM INT,
	BOARD_NAME VARCHAR(20) NOT NULL,
	BOARD_PASS VARCHAR(15) NOT NULL,
	BOARD_SUBJECT VARCHAR(50) NOT NULL,
	BOARD_CONTENT VARCHAR(2000) NOT NULL,
	BOARD_FILE VARCHAR(50) NOT NULL,
	BOARD_RE_REF INT NOT NULL,
	BOARD_RE_LEV INT DEFAULT 0,
	BOARD_RE_SEQ INT DEFAULT 0,
	BOARD_READCOUNT INT DEFAULT 0,
	BOARD_DATE DATETIME DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(BOARD_NUM)
); 

CREATE TABLE if not exists web_gradle_erp.users (
	uid	    INT	NOT NULL AUTO_INCREMENT,
	id   	VARCHAR(12) NOT NULL UNIQUE COMMENT '아이디', -- 아이디
	passwd  CHAR(41)    NOT NULL COMMENT '비밀번호', -- 비밀번호
	email   VARCHAR(60) COMMENT '이메일', -- 이메일
	PRIMARY KEY (UID)
)
COMMENT '사용자';


INSERT INTO users(id, passwd, email) 
       VALUES('test1', password('1234'), 'test1@test.co.kr');

INSERT INTO users(id, passwd, email) 
       VALUES('test2', password('1234'), 'test2@test.co.kr');

      select * from users;

select * from users;

SELECT id 
  FROM users 
 WHERE id = 'test1' 
   AND passwd = password('1234');

