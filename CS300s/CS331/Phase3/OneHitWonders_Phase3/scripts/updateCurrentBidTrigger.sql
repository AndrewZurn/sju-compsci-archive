DROP TRIGGER IF EXISTS UPDATE_ITEM_CURRENT_BID;
delimiter &&
CREATE TRIGGER UPDATE_ITEM_CURRENT_BID
BEFORE INSERT ON AUCTIONS
	FOR EACH ROW
	BEGIN
	
		declare oldMaxBid int;
		declare currentBid int;
		declare itemStatus varchar(16);
	
		SELECT MAX(MAXIMUM_BID) into oldMaxBid
		FROM AUCTIONS
		WHERE ITEM_ID = NEW.ITEM_ID;
		
		SELECT CURRENT_BID into currentBid
		FROM ITEM
		WHERE ITEM_ID = NEW.ITEM_ID;
	
		SELECT STATUS into itemStatus
		FROM ITEM
		WHERE ITEM_ID = NEW.ITEM_ID;
	
		IF( itemStatus = 'Open' AND NEW.MAXIMUM_BID > oldMaxBid ) THEN
			UPDATE ITEM SET CURRENT_BID = oldMaxBid + 1 WHERE ITEM_ID = NEW.ITEM_ID;
		ELSEIF( itemStatus = 'Open' AND (NEW.MAXIMUM_BID < oldMaxBid AND NEW.MAXIMUM_BID > currentBid) ) THEN
			UPDATE ITEM SET CURRENT_BID = NEW.MAXIMUM_BID + 1 WHERE ITEM_ID = NEW.ITEM_ID;
		END IF;	
	
	END &&
delimiter ;