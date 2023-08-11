SELECT A.USER_ID, A.NICKNAME, SUM(B.PRICE) AS TOTAL_SALES
FROM USED_GOODS_USER A JOIN USED_GOODS_BOARD B
ON A.USER_ID = B.WRITER_ID
WHERE B.STATUS = 'DONE'
GROUP BY USER_ID
HAVING TOTAL_SALES >= 700000
ORDER BY TOTAL_SALES