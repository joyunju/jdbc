-- 테이블 삭제 
DROP TABLE author;
DROP TABLE book;

-- 시퀀스 삭제
drop sequence seq_book_id;

-- book 테이블 만들기
CREATE TABLE book (
    book_id   NUMBER(10),
    title     VARCHAR2(100) NOT NULL,
    pubs      VARCHAR2(100),
    pub_date  DATE,
    author_id NUMBER(10),
    PRIMARY KEY ( book_id ),
    CONSTRAINT book_fk FOREIGN KEY ( author_id )
    REFERENCES author ( author_id )
);


-- book 시퀀스 만들기 : 시퀀스 seq_book_id
CREATE SEQUENCE seq_book_id
INCREMENT BY 1
START WITH 1 
nocache;


-- book 테이블 컬럼 생성
-- seq_book_id.nextval 1정보 생성
INSERT INTO book VALUES (
    seq_book_id.NEXTVAL,
    '우리들의 일그러진 영웅',
    '다림',
    '1998-02-22',
    1
);

-- 조건을 만족하는 레코드 변경
UPDATE book
SET
    book_id = '',
    title = '',
    pubs = '',
    pub_date = '',
    author_id = ''
WHERE
    book_id = 1;
    
    
-- 조건을 만족하는 레코드 삭제
DELETE FROM book
WHERE book_id = 1 ;

-- 출력 확인
SELECT
    * FROM book;

-- eclipse 용    
SELECT
    book_id,
    title,
    pubs,
    pub_date,
    author_id
FROM
    book;
    
COMMIT;
rollback;


-- ■ book 테이블과 author 테이블 join
SELECT
    bo.book_id,
    bo.title,
    bo.pubs,
    --bo.pub_date,
    to_char(bo.pub_date, 'YYYY-MM-DD') "pub_date",
    bo.author_id,
    au.author_name,
    au.author_desc
FROM
    book   bo,
    author au
WHERE
    bo.author_id = au.author_id;

