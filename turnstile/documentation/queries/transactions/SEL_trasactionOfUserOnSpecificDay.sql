--get all the transaction of a specific user on a specific day
SELECT
    T.DATE,
    U.NAME,
    U.SURNAME,
    T.ID AS TRANSACTION_ID,
    T.ENTER_TIME,
    T.EXIT_TIME,
    T.TURNSTILE_ID
FROM
    USERS AS U
JOIN TRANSACTIONS AS T ON T.USER_ID = U.ID
WHERE
    U.ID = 1
    AND T.DATE = '2025-02-25';

