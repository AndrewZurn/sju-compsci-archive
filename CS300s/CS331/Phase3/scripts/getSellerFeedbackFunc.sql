Drop function if exists getSellerFeedback;
delimiter &&
Create Function getSellerFeedback(id int) Returns int
	Begin
		declare user int;
		
		SELECT USER_ID into user
		FROM AUCTIONS
		WHERE MAXIMUM_BID=(
			SELECT max(MAXIMUM_BID)
			FROM AUCTIONS
			WHERE ITEM_ID = id AND EXISTS(
				SELECT *
				FROM SELLER_FEEDBACK
				WHERE ITEM_ID=id ));
				
		Return user;
		End
		&&
delimiter ;
