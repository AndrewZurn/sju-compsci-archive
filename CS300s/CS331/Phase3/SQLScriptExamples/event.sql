drop table if exists dummy;
create table dummy(
	currDataTime datetime
);

drop event if exists silly_event;
delimiter &&
Create Event silly_event
	On Schedule every 10 SECOND
	DO
		Insert Into dummy values (now());
	&&
delimiter ;
