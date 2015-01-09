DROP PROCEDURE IF EXISTS updateItemStatus;
delimiter &&
CREATE PROCEDURE updateItemStatus(IN itemId int)
	BEGIN
		declare startTime TIMESTAMP;
		declare endTime TIMESTAMP;
		declare auctionItemId INTEGER;
		
		set auctionItemId = 0;
		
		SELECT AUCTION_START into startTime
		FROM ITEM
		WHERE ITEM_ID = itemId;
		
		SELECT AUCTION_END into endTime
		FROM ITEM
		WHERE ITEM_ID = itemId;
		
		SELECT DISTINCT ITEM_ID into auctionItemId
		FROM AUCTIONS
		WHERE ITEM_ID = itemId;
		
		IF ( startTime > NOW() ) THEN
			UPDATE ITEM SET STATUS = 'Starting Soon'
			WHERE ITEM_ID = itemId;
		ELSEIF ( startTime <= NOW() AND endTime >= NOW() ) THEN
			UPDATE ITEM SET STATUS = 'Open'
			WHERE ITEM_ID = itemId;
		ELSEIF ( endTime < NOW() AND NOT(auctionItemId = 0) ) THEN
			UPDATE ITEM SET STATUS = 'Sold'
			WHERE ITEM_ID = itemId;
		ELSEIF ( endTime < NOW() AND auctionItemId = 0 ) THEN
			UPDATE ITEM SET STATUS = 'Closed'
			WHERE ITEM_ID = itemId;
		ELSE
			UPDATE ITEM SET STATUS = 'UNKNOWN'
			WHERE ITEM_ID = itemId;
		End IF;
		
	END &&
delimiter ;
