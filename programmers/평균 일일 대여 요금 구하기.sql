SELECT ROUND(AVG(DAILY_FEE)) AS AVERAGE_FEE
FROM CAR_RENTAL_COMPANY_CAR
WHERE CAR_TYPE = 'SUV'
-- 정확한 일치를 원할 때: = 연산자를 사용(문제와 같은 경우)
-- 부분 일치나 패턴 매칭을 원할 때: LIKE 연산자를 사용, 주로 %나 _ 같은 와일드카드 연산자와 같이 사용