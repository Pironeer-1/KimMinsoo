SELECT ANIMAL_ID, NAME, SEX_UPON_INTAKE 
FROM ANIMAL_INS 
WHERE NAME = 'Lucy' OR NAME = 'Ella' OR NAME = 'Pickle' OR NAME = 'Rogan' OR
NAME = 'Sabrina' OR NAME = 'Mitty'
ORDER BY ANIMAL_ID

-- 더 쉬운 답
-- SELECT ANIMAL_ID, NAME, SEX_UPON_INTAKE
-- FROM ANIMAL_INS 
-- WHERE NAME IN ('Lucy', 'Ella', 'Pickle', 'Rogan', 'Sabrina', 'Mitty')
-- ORDER BY ANIMAL_ID;
-- WHERE ~ IN 구문을 사용하면 여러 조건을 쉽게 표현할 수 있다