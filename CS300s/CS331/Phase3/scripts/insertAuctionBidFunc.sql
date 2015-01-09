DROP FUNCTION IF EXISTS insertAuctionBid;
delimiter &&
CREATE FUNCTION insertAuctionBid(itemId INTEGER, userId INTEGER, maxBid decimal(9,2)) RETURNS int
	BEGIN
	
	declare itemStatus varchar(16);
	declare currentBid decimal(9,2);
	
	SELECT STATUS into itemStatus
	FROM ITEM
	WHERE ITEM_ID = itemId;
	
	SELECT CURRENT_BID into currentBid
	FROM ITEM
	WHERE ITEM_ID = itemId;
	
	IF ( itemStatus = 'Open' ) THEN
		IF ( maxBid > currentBid ) THEN
			INSERT INTO AUCTIONS VALUES (itemId, userId, maxBid, NOW());
			return 0; -- good bid, bid was inserted into AUCTIONS
		ELSE
			return -1; -- the max bid was less than the current bid
		END IF;
	ELSE
		return -2; -- the auction for this item was not open
	END IF;
	
	END &&
delimiter ;