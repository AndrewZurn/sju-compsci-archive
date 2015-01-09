-- The following is a function that returns the number of employees in a department
drop function if exists returnNumEmployees;
delimiter &&
Create Function returnNumEmployees(deptNum int) Returns int
	Begin
		declare numEmps int;
		set numEmps=0;
		Select Count(*) into numEmps from employee where dno = deptNum;
		If  (numEmps<0) Then
			set numEmps=0;
		End If;
		Return  numEmps;
	End 
	&&
delimiter ;
