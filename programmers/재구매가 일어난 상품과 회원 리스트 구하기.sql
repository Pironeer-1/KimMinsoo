SELECT USER_ID, PRODUCT_ID 
FROM ONLINE_SALE
GROUP BY USER_ID, PRODUCT_ID 
-- USER_ID와 PRODUCT_ID를 기준으로 데이터를 묶음 
-- 즉 (유저 아이디 - 제품 아이디) 세트가 여러 개 있으면 하나의 그룹으로 묶음
HAVING COUNT(USER_ID) > 1
-- 동일한 (유저 아이디 - 제품 아이디) 세트가 2개 이상인 그룹만 필터링함
ORDER BY USER_ID, PRODUCT_ID DESC