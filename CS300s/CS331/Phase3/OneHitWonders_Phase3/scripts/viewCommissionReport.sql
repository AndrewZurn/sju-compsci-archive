DROP VIEW IF EXISTS COMMISSION_REPORT;
CREATE VIEW COMMISSION_REPORT(SELLER_ID, ITEM_ID, USERNAME,  FIRST_NAME, LAST_NAME, EMAIL, SELLER_RATING, COMMISSION) AS
SELECT I.CREATOR_ID, I.ITEM_ID, U.USERNAME, U.FIRST_NAME, U.LAST_NAME, U.EMAIL, AVG(S.SATISFACTION), 	(I.CURRENT_BID *0.2) AS COMMISSION
	FROM ITEM I, USERS U, SELLER_FEEDBACK S, AUCTIONS A
	WHERE I.CREATOR_ID = U.USER_ID AND I.ITEM_ID = S.ITEM_ID AND
		I.ITEM_ID = A.ITEM_ID AND I.STATUS = 'Sold'
	GROUP BY I.CREATOR_ID, I.ITEM_ID, U.USERNAME, U.FIRST_NAME, U.LAST_NAME, U.EMAIL;
