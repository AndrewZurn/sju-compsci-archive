 drop procedure if exists update_status;
 delimiter &&
 CREATE procedure update_status()
 	BEGIN
		DECLARE done VARCHAR(5) DEFAULT 'START';
		DECLARE a INT;
		DECLARE cur CURSOR FOR SELECT ITEM_ID FROM ITEM;
		DECLARE CONTINUE HANDLER FOR NOT FOUND SET done='END';
		OPEN cur;
			WHILE done <> 'END' DO
				FETCH cur INTO a;
				CALL updateItemStatus(a);
			END WHILE;
		CLOSE cur;
	END;
 &&
 delimiter ;
