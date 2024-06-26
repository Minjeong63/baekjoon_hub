SELECT B.AUTHOR_ID, AUTHOR_NAME, CATEGORY, SUM(SALES * PRICE) AS TOTAL_SALES
FROM BOOK A LEFT OUTER JOIN AUTHOR B
ON A.AUTHOR_ID = B.AUTHOR_ID
LEFT OUTER JOIN BOOK_SALES C
ON A.BOOK_ID = C.BOOK_ID
WHERE SALES_DATE LIKE '2022-01%'
GROUP BY CATEGORY, AUTHOR_ID
ORDER BY B.AUTHOR_ID, CATEGORY DESC