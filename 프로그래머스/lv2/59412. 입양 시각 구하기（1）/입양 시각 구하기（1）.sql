SELECT date_format(DATETIME, '%H') as HOUR, COUNT(DATETIME) FROM ANIMAL_OUTS GROUP BY HOUR HAVING HOUR >= 9 AND HOUR <= 19 ORDER BY HOUR;