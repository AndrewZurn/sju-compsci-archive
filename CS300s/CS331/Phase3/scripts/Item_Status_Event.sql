
 DROP EVENT IF EXISTS status_event;
 delimiter &&
 CREATE EVENT status_event
	ON SCHEDULE EVERY 1 MINUTE
	Do
		CALL update_status();
	&&
 delimiter ;



