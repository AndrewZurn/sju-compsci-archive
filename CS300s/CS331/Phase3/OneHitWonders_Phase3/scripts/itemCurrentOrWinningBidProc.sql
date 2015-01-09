DROP PROCEDURE IF EXISTS itemCurrentOrWinningBid;
delimiter &&
CREATE PROCEDURE itemCurrentOrWinningBid(IN itemId int, OUT itemStatus varchar(16),
											OUT userId int, OUT price decimal(9,2))
	BEGIN
		
		SELECT STATUS into itemStatus
		FROM ITEM
		WHERE ITEM_ID = itemId;
		
		SELECT WINNER_ID into userId
		FROM ITEM
		WHERE ITEM_ID = itemId;
		
		SELECT CURRENT_BID into price
		FROM ITEM
		WHERE ITEM_ID = itemId;
		
	END &&
delimiter ;