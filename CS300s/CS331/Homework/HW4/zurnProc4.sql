drop procedure if exists PROC_INCREASE_LIMIT;
delimiter &&
Create procedure PROC_INCREASE_LIMIT(IN custNum int, IN partNum char(4))
	Begin
		declare foundCustomer int;
		set foundCustomer = 0;
		
		SELECT DISTINCT c.CUSTOMER_NUMBER into foundCustomer 
		FROM CUSTOMER as c, TRANS as t, TRANS_PART as tp
		WHERE c.CUSTOMER_NUMBER = custNum AND t.CUSTOMER_NUMBER = c.CUSTOMER_NUMBER
		  AND tp.TRANS_NUMBER = t.TRANS_NUMBER AND tp.PART_NUMBER = partNum;
		  
		If  (foundCustomer <> 0) Then
			UPDATE CUSTOMER SET CREDIT_LIMIT = CREDIT_LIMIT * 1.1
			WHERE CUSTOMER_NUMBER = foundCustomer;
		End If;
	End 
	&&
delimiter ;
