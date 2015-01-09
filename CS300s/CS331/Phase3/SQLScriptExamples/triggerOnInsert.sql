drop trigger IF EXISTS UPDATE_DEPTS_INFO_INSERT;
delimiter &&
CREATE TRIGGER UPDATE_DEPTS_INFO_INSERT
	AFTER INSERT ON employee
	For Each Row
		Begin 
		UPDATE DEPTS_INFO 
			SET 	NO_OF_EMPS=NO_OF_EMPS +1,
				TOTAL_SAL = TOTAL_SAL+NEW.salary 
			where DEPT_NUM=NEW.dno;
		End &&
delimiter ;
