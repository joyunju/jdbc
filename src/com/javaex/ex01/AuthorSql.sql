-- 테이블 삭제 
DROP TABLE author;
DROP TABLE book;

-- 시퀀스 삭제
drop sequence seq_author_id;

-- author 테이블 만들기
CREATE TABLE author (
    author_id   NUMBER(10),
    author_name VARCHAR2(100) NOT NULL,
    author_desc VARCHAR2(500),
    PRIMARY KEY ( author_id )
);


-- 작가 시퀀스 만들기
CREATE SEQUENCE seq_author_id
INCREMENT BY 1
START WITH 1 
nocache;

--author 데이터 입력
INSERT INTO author VALUES (
    seq_author_id.nextval,
    '김문열',
    '경북 영양'
);

-- 조건을 만족하는 레코드 변경
UPDATE author
SET author_name = '기안84' ,
author_desc = '웹툰작가'
WHERE author_id = 1 ;

-- 조건을 만족하는 레코드 삭제
DELETE FROM author
WHERE author_id = 1 ;

SELECT
    * FROM author;

-- eclipse 용    
SELECT
    author_id,
    author_name,
    author_desc
FROM
    author;
    
COMMIT;
rollback;

