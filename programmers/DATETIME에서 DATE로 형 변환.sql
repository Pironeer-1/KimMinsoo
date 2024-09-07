SELECT ANIMAL_ID, NAME, DATE_FORMAT(DATETIME, '%Y-%m-%d') AS 날짜 
-- DATE_FORMAT 함수, 변형하고 싶은 값을 받아서(첫 번째 인자), 변형하고 싶은 형식으로 변환(두 번째 인자)
FROM ANIMAL_INS
ORDER BY ANIMAL_ID