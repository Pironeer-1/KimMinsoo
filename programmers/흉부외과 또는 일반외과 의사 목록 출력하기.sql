SELECT DR_NAME, DR_ID, MCDP_CD, DATE_FORMAT(HIRE_YMD, '%Y-%m-%d') AS HIRE_YMD
-- DATE_FORMAT 함수로 날짜 형식을 변환 가능(시분초는 필요 없어서 생략했어야 함)
FROM DOCTOR 
WHERE MCDP_CD = 'CS' OR MCDP_CD = 'GS'
ORDER BY HIRE_YMD DESC, DR_NAME ASC;
-- ORDER BY의 기본값은 오름차순이다. 즉 ASC는 생략 가능