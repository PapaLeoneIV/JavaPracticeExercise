SELECT * FROM TRANSACTION_EVENT 
JOIN TRANSACTIONS AS T ON T.ID = TRANSACTION_EVENT.TRANSACTION_ID
WHERE T.ID = 1;
