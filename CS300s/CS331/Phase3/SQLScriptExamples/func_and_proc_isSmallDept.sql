drop function if exists isSmallDept;
delimiter &&
Create function isSmallDept(deptNum int, minLimit int) Returns boolean
	Begin
		declare numEmps int;
		declare answer boolean default false;
		Select Count(*) into numEmps from employee where dno = deptNum;
		If  (numEmps<minLimit) Then
			set  answer = true;
		End If;
		Return  answer;
	End 
	&&
delimiter ;

drop procedure if exists isSmallDeptP;
delimiter &&
Create procedure isSmallDeptP(IN deptNum int, IN minLimit int, OUT answer boolean)
	Begin
		declare numEmps int;
		set answer = false;
		Select Count(*) into numEmps from employee where dno = 				deptNum;
		If  (numEmps<minLimit) Then
			set  answer = true;
		End If;
	End 
	&&
delimiter ;

