SELECT OUTS.ANIMAL_ID, OUTS.ANIMAL_TYPE, OUTS.NAME
FROM ANIMAL_OUTS OUTS INNER JOIN ANIMAL_INS INS
ON OUTS.ANIMAL_ID = INS.ANIMAL_ID
WHERE INS.SEX_UPON_INTAKE = 'Intact Male' AND OUTS.SEX_UPON_OUTCOME = 'Neutered Male' OR INS.SEX_UPON_INTAKE = 'Intact Female' AND OUTS.SEX_UPON_OUTCOME = 'Spayed Female'
ORDER BY OUTS.ANIMAL_ID