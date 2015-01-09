-- The following is a procedure that returns the number of employees in a department using an OUT parameter
drop procedure if exists numEmployees;
delimiter &&
Create Procedure numEmployees(IN deptNum int, OUT numEmps int)
	Begin
		set numEmps=0;
		Select Count(*) into numEmps from employee where dno = deptNum;
	End
	&&
delimiter ;
