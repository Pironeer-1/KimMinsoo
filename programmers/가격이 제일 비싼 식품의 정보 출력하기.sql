SELECT * FROM FOOD_PRODUCT
-- 상품을 불러오는데,
WHERE PRICE = (SELECT MAX(PRICE) FROM FOOD_PRODUCT)
-- 가격이 가장 비싼 상품을 필터링해서 불러와라~