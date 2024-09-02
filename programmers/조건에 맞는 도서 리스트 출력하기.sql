-- BOOK 테이블에서 2021년에 출판된 '인문' 카테고리에 속하는 도서 리스트를 찾아서 도서 ID(BOOK_ID), 출판일 (PUBLISHED_DATE)을 출력하는 SQL문을 작성해주세요. 결과는 출판일을 기준으로 오름차순 정렬해주세요.

SELECT BOOK_ID, DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') 
AS PUBLISHED_DATE FROM BOOK
WHERE CATEGORY = '인문' AND PUBLISHED_DATE LIKE '2021-%'
-- 와일드카드 문자
-- %: '0'개 이상의 임의의 문자에 일치
-- '%SQL% -> SQL이 포함된 문자열을 찾음
-- _: 정확히 하나의 문자에 일치
-- 'S_Q' -> S로 시작하고, Q로 끝나는 문자열을 찾음
ORDER BY PUBLISHED_DATE;