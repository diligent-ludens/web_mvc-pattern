DROP TABLE DETAIL purge;

CREATE TABLE DETAIL(
	DETAIL_NUM NUMBER,
	DETAIL_NAME VARCHAR2(50),
	DETAIL_CATEGORY VARCHAR2(20),
	DETAIL_CONTENT VARCHAR2(3000),
	DETAIL_IMAGE VARCHAR2(50),
	DETAIL_ADDTER VARCHAR2(3000),
	PRIMARY KEY(DETAIL_NUM)
);

select*from DETAIL;

/* 후보자
DETAIL_LIKE NUMBER,
DETAIL_LOCATION NUMBER,
DETAIL_IMAGE1 VARCHAR2(50),
DETAIL_IMAGE2 VARCHAR2(50),
*/

/* 실험용 sql문*/
select * from detail order by DETAIL_NUM;

insert into DETAIL values (1, '유가네', '한식', '닭갈비 전문점', '이미지', '볶음밥 추천!');
insert into DETAIL values (2, '홍콩반점', '중식', '전형적 중국집', '이미지', '다양한 메뉴!');
insert into DETAIL values (3, '집스테이크', '양식', '찹스테이크', '이미지', '적당한 가격!');
insert into DETAIL values (4, '스쿱 카페', '분식', '커피', '이미지', '마카롱 추천!');
insert into DETAIL values (5, '왕십리곱창', '한식', '곱창 전문점', '이미지', '소금 양념 반반!');

select DETAIL_NUM, DETAIL_NAME, DETAIL_CATEGORY from 
(select rownum rnum, DETAIL_NUM, DETAIL_NAME, DETAIL_CATEGORY from DETAIL
where DETAIL_CATEGORY = '한식');





